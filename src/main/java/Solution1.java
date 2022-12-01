//import java.util.ArrayList;
//import java.util.Comparator;
//import java.util.Queue;
//
//public class Solution1 {
//    public static void main(String[] args) {
//        Solution1 solution1 = new Solution1();
//        String[] maps = {
//                "AABCA.QA",
//                "AABC..QX",
//                "BBBC.Y..",
//                ".A...T.A",
//                "....EE..",
//                ".M.XXEXQ",
//        };
//        solution1.solution(maps);
//    }
//    public int solution(String[] maps) {
//        String[][] detailMaps = getDetailMaps(maps);
//        boolean[][] visitMaps = new boolean[detailMaps.length][detailMaps[0].length];
//        Map<String, Integer> totalScore = new HashMap<>();
//        for (int i = 0; i < detailMaps.length; i++) {
//            for (int j = 0; j < detailMaps[i].length; j++) {
//                if (detailMaps[i][j].charAt(0) > 64 && detailMaps[i][j].charAt(0) < 91 && !visitMaps[i][j]) {
//                    calculateGameWar(detailMaps, visitMaps, i, j, totalScore);
//                }
//            }
//        }
//
//        List<Map.Entry<String, Integer>> entries = new LinkedList<>(totalScore.entrySet());
//        entries.sort(Map.Entry.comparingByValue());
//        Map.Entry<String, Integer> winnerScore = entries.get(entries.size() - 1);
//
//        return winnerScore.getValue();
//    }
//
//    private Map<String, Integer> calculateGameWar(String[][] detailMaps, boolean[][] visitMaps, int x, int y, Map<String, Integer> totalScore) {
//        Map<String, Integer> countryScore = new HashMap<>();
//        Coordinate startCoordinate = new Coordinate(x, y);
//        Queue<Coordinate> bfs = new LinkedList<>();
//        bfs.add(startCoordinate);
//        countryScore.put(detailMaps[x][y], 1);
//        visitMaps[x][y] = true;
//
//
//        findCountryPower(detailMaps, visitMaps, countryScore, bfs);
//        Map<String, Integer> resultWar = getResultWar(countryScore, totalScore);
//
//        return resultWar;
//    }
//
//    private Map<String, Integer> getResultWar(Map<String, Integer> countryScore, Map<String, Integer> totalScore) {
//        List<String> winners = new ArrayList<>();
//        List<Map.Entry<String, Integer>> entries = new LinkedList<>(countryScore.entrySet());
//        entries.sort(Map.Entry.comparingByValue());
//        Map.Entry<String, Integer> winner = entries.get(entries.size() - 1);
//
//        int winnerValue = winner.getValue();
//
//        for (String country : countryScore.keySet()) {
//            if(countryScore.get(country) == winnerValue) {
//                winners.add(country);
//            }
//        }
//
//        winners.sort(Comparator.reverseOrder());
//        String winnerCountry = winners.get(0);
//        int score = countryScore.get(winnerCountry);
//        for (String country : countryScore.keySet()) {
//            if(countryScore.get(country) < countryScore.get(winnerCountry)) {
//                score += countryScore.get(country);
//            }
//        }
//
//        if(totalScore.containsKey(winnerCountry)) {
//            totalScore.put(winnerCountry, totalScore.get(winnerCountry) + score);
//        } else {
//            totalScore.put(winnerCountry, score);
//        }
//        return totalScore ;
//    }
//
//    private void findCountryPower(String[][] detailMaps, boolean[][] visitMaps, Map<String, Integer> countryScore, Queue<Coordinate> bfs) {
//        while(!bfs.isEmpty()) {
//            Coordinate coordinate = bfs.poll();
//            int x = coordinate.getX();
//            int y = coordinate.getY();
//            if(x - 1 > 0 && !visitMaps[x - 1][y] &&
//                    detailMaps[x-1][y].charAt(0) > 64 && detailMaps[x-1][y].charAt(0) < 91) {
//                bfs.add(new Coordinate(x-1, y));
//                if(!countryScore.containsKey(detailMaps[x-1][y])) {
//                    countryScore.put(detailMaps[x-1][y], 1);
//                } else {
//                    countryScore.put(detailMaps[x-1][y], countryScore.get(detailMaps[x-1][y]) + 1);
//                }
//                visitMaps[x-1][y] = true;
//            }
//            if(y - 1 > 0 && !visitMaps[x][y - 1] &&
//                    detailMaps[x][y-1].charAt(0) > 64 && detailMaps[x][y-1].charAt(0) < 91) {
//                bfs.add(new Coordinate(x, y-1));
//                if(!countryScore.containsKey(detailMaps[x][y-1])) {
//                    countryScore.put(detailMaps[x][y-1], 1);
//
//                } else {
//                    countryScore.put(detailMaps[x][y-1], countryScore.get(detailMaps[x][y-1]) + 1);
//                }
//                visitMaps[x][y-1] = true;
//            }
//            if (x + 1 < detailMaps.length && !visitMaps[x + 1][y] &&
//                    detailMaps[x + 1][y].charAt(0) > 64 && detailMaps[x + 1][y].charAt(0) < 91) {
//                bfs.add(new Coordinate(x + 1, y));
//                if (!countryScore.containsKey(detailMaps[x + 1][y])) {
//                    countryScore.put(detailMaps[x + 1][y], 1);
//                } else {
//                    countryScore.put(detailMaps[x + 1][y], countryScore.get(detailMaps[x + 1][y]) + 1);
//                }
//                visitMaps[x + 1][y] = true;
//            }
//            if (y + 1 < detailMaps[x].length && !visitMaps[x][y + 1] &&
//                    detailMaps[x][y + 1].charAt(0) > 64 && detailMaps[x][y + 1].charAt(0) < 91) {
//                bfs.add(new Coordinate(x, y + 1));
//                if (!countryScore.containsKey(detailMaps[x][y + 1])) {
//                    countryScore.put(detailMaps[x][y + 1], 1);
//
//                } else {
//                    countryScore.put(detailMaps[x][y + 1], countryScore.get(detailMaps[x][y + 1]) + 1);
//                }
//                visitMaps[x][y + 1] = true;
//            }
//        }
//    }
//
//    private String[][] getDetailMaps(String[] maps) {
//        String[][] detailMaps = new String[maps.length][maps[0].length()];
//        for (int i = 0; i < detailMaps.length; i++) {
//            for (int j = 0; j < detailMaps[i].length; j++) {
//                String[] alphabet = maps[i].split("");
//                detailMaps[i][j] = alphabet[j];
//            }
//        }
//        return detailMaps;
//    }
//    class Coordinate {
//        int x;
//        int y;
//
//        public Coordinate(int x, int y) {
//            this.x = x;
//            this.y = y;
//        }
//
//        public int getX() {
//            return x;
//        }
//
//        public int getY() {
//            return y;
//        }
//    }
//
//}
