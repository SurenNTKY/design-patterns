import Decorators.GoalKeeperCardDecorator.*;
import Decorators.PlayerCardDecorator.*;
import Directors.Director;
import Models.*;
import Strategies.AggressiveStrategy;
import Strategies.BalancedStrategy;
import Strategies.DefensiveStrategy;
import Strategies.PlayStyle;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Director director = new Director();
        Club myClub = new Club(1000000000);
        Map<String, Card> market = new HashMap<>();
        Map<String, Card> lineup = new HashMap<>();

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running && scanner.hasNextLine()) {
            String[] p = scanner.nextLine().trim().split("\\s+");
            if (p.length == 0) continue;

            switch (p[0].toLowerCase()) {
                case "build":
                    if ("player".equalsIgnoreCase(p[1])) {
                        PlayerCard playerCard = director.createPlayer(
                                p[2], p[3],
                                Integer.parseInt(p[4]), Integer.parseInt(p[5]),
                                Integer.parseInt(p[6]), Integer.parseInt(p[7]),
                                Integer.parseInt(p[8]), Integer.parseInt(p[9])
                        );
                        market.put(p[2], playerCard);
                    } else if ("goalie".equalsIgnoreCase(p[1])) {
                        GoalKeeperCard goalKeeperCard = director.createGoalKeeper(
                                p[2], p[3],
                                Integer.parseInt(p[4]), Integer.parseInt(p[5]),
                                Integer.parseInt(p[6]), Integer.parseInt(p[7]),
                                Integer.parseInt(p[8]), Integer.parseInt(p[9])
                        );
                        market.put(p[2], goalKeeperCard);
                    }
                    break;

                case "buy":
                    Card cardToBuy = market.get(p[1]);
                    if (cardToBuy != null) {
                        long price = cardToBuy.getPrice();
                        if (price <= myClub.getBudget()) {
                            myClub.setBudget(myClub.getBudget() - (int) price);
                            myClub.addCard(cardToBuy);
                        } else {
                            System.out.println("8 - 2");
                        }
                    }
                    break;

                case "sell":
                    Card cardToSell = myClub.findCardByName(p[1]);
                    if (cardToSell != null) {
                        long sellPrice = cardToSell.getPrice() / 2;
                        myClub.setBudget(myClub.getBudget() + (int) sellPrice);
                        myClub.removeCard(cardToSell);
                    }
                    break;

                case "select":
                    Card selected = myClub.findCardByName(p[2]);
                    if (selected != null) {
                        lineup.put(p[1], selected);
                    }
                    break;

                case "set":
                    if (p.length == 4 && "decoration".equalsIgnoreCase(p[1])) {
                        String position = p[2];
                        String decoration = p[3];
                        Card original = lineup.get(position);
                        if (original instanceof PlayerCard) {
                            PlayerCard decorated = switch (decoration) {
                                case "bronze" -> new BronzePlayerCardDecorator((PlayerCard) original);
                                case "silver" -> new SilverPlayerCardDecorator((PlayerCard) original);
                                case "gold" -> new GoldPlayerCardDecorator((PlayerCard) original);
                                case "hero" -> new HeroPlayerCardDecorator((PlayerCard) original);
                                case "icon" -> new IconPlayerCardDecorator((PlayerCard) original);
                                default -> (PlayerCard) original;
                            };
                            long cost = decorated.getPrice() - ((PlayerCard) original).getPrice();
                                myClub.setBudget(myClub.getBudget() - (int) cost);
                                lineup.put(position, decorated);
                        }
                        else if (original instanceof GoalKeeperCard) {
                            GoalKeeperCard baseGk = (GoalKeeperCard) original;
                            GoalKeeperCard decoratedGk = switch (decoration) {
                                case "bronze" -> new BronzeGoalKeeperCardDecorator(baseGk);
                                case "silver" -> new SilverGoalKeeperDecorator(baseGk);
                                case "gold" -> new GoldGoalKeeperCardDecorator(baseGk);
                                case "hero" -> new HeroGoalKeeperCardDecorator(baseGk);
                                case "icon" -> new IconGoalKeeperCardDecorator(baseGk);
                                default -> baseGk;
                            };
                            long costGk = decoratedGk.getPrice() - baseGk.getPrice();
                            if (costGk <= myClub.getBudget()) {
                                myClub.setBudget(myClub.getBudget() - (int) costGk);
                                lineup.put(position, decoratedGk);
                            }
                        }
                    } else if (p.length == 5 && "play".equalsIgnoreCase(p[1]) && "style".equalsIgnoreCase(p[2])) {
                        String position = p[3];
                        String styleStr = p[4].toLowerCase();
                        Card c2 = lineup.get(position);
                        if (c2 instanceof PlayerCard) {
                            PlayerCard pc2 = (PlayerCard) c2;
                            PlayStyle style;
                            switch (styleStr) {
                                case "aggressive": style = new AggressiveStrategy(); break;
                                case "defensive": style = new DefensiveStrategy(); break;
                                default: style = new BalancedStrategy();
                            }
                            pc2.setPlayStyle(style);
                        }
                    }
                    break;

                case "show":
                    if (p.length >= 2 && "lineup".equalsIgnoreCase(p[1])) {
                        printOut(lineup.get("st"), "striker");
                        printOut(lineup.get("cb"), "center back");
                        printGK(lineup.get("gk"), "goal keeper");
                    } else if (p.length >= 2 && "money".equalsIgnoreCase(p[1])) {
                        System.out.println(myClub.getBudget());
                    }
                    break;

                case "calculate":
                    if (p.length == 3 && "team".equalsIgnoreCase(p[1]) && "power".equalsIgnoreCase(p[2])) {
                        int teamPower = computeTeamPower(lineup);
                        System.out.println(teamPower);
                    }
                    break;

                case "soot":
                    int finalPower = computeTeamPower(lineup);
                    if (finalPower > 90) {
                        System.out.println("Visca Barca");
                    } else if (finalPower == 90) {
                        System.out.println("draw");
                    } else {
                        System.out.println("Hala Madrid");
                    }
                    running = false;
                    break;
            }
        }

        scanner.close();
    }

    private static void printOut(Card c, String label) {
        if (!(c instanceof PlayerCard)) {
            System.out.println(label + ":");
            return;
        }
        PlayerCard pc = (PlayerCard) c;
        String style = getStyleName(pc);
        System.out.printf(
                "%s: %s %s %d %d %d %d %d %d %s%n",
                label,
                pc.getName(),
                pc.getNationality(),
                pc.getShooting(),
                pc.getPace(),
                pc.getDribbling(),
                pc.getPhysic(),
                pc.getPassing(),
                pc.getDefending(),
                style
        );
    }

    private static void printGK(Card c, String label) {
        if (!(c instanceof GoalKeeperCard)) {
            System.out.println(label + ":");
            return;
        }
        GoalKeeperCard gk = (GoalKeeperCard) c;
        System.out.printf(
                "%s: %s %s %d %d %d %d %d %d%n",
                label,
                gk.getName(),
                gk.getNationality(),
                gk.getDiving(),
                gk.getHandling(),
                gk.getReflex(),
                gk.getPositioning(),
                gk.getKicking(),
                gk.getSpeed()
        );
    }

    private static String getStyleName(PlayerCard pc) {
        PlayStyle ps = pc.getPlayStyle();
        if (ps instanceof AggressiveStrategy) return "aggressive";
        if (ps instanceof DefensiveStrategy) return "defensive";
        return "balanced";
    }

    private static int computeTeamPower(Map<String, Card> lineup) {
        int sum = 0;
        sum += playerPower(lineup.get("st"));
        sum += playerPower(lineup.get("cb"));
        sum += goalkeeperPower(lineup.get("gk"));
        return sum / 3;
    }

    private static int playerPower(Card c) {
        if (!(c instanceof PlayerCard)) return 0;
        PlayerCard pc = (PlayerCard) c;
        return (int) Math.floor(pc.getOverallPower());
    }

    private static int goalkeeperPower(Card c) {
        if (!(c instanceof GoalKeeperCard)) return 0;
        GoalKeeperCard gk = (GoalKeeperCard) c;
        double avg = (
                gk.getDiving() +
                        gk.getHandling() +
                        gk.getReflex() +
                        gk.getPositioning() +
                        gk.getKicking() +
                        gk.getSpeed()
        ) / 6.0;
        return (int) Math.floor(avg);
    }
}
