import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class KakaoCache {
    public  void main(String[] args) {
        String[] cities = {"Jeju", "jeju", "jeju", "jeju"};
        System.out.println(solution(0, cities));
    }

    public  int solution(int cacheSize, String[] cities) {
        int answer = 0;

        List<City> cityList = new ArrayList<>();
        System.out.println(cityList.size() + "size");
        for (int i = 0; i < cities.length; i++) {
            String city = cities[i].toUpperCase(Locale.ROOT);
            if(cityList.isEmpty()) {
                cityList.add(new City(1, city));
                answer += 5;
            } else {
                if(isContainCity(cityList,city) && cityList.size() <= cacheSize) {
                    hitLRU(cityList, city);
                    answer += 1;
                } else if(!isContainCity(cityList, city) || cityList.size() > cacheSize) {
                    remove(cityList, cacheSize);
                    increase(cityList);
                    cityList.add(new City(1, city));
                    answer += 5;
                }
            }
        }

        return answer;
    }

    private  void increase(List<City> cityList) {
        for (City targetCity : cityList) {
            targetCity.increaseRecently();
        }
    }

    private  void remove(List<City> cityList, int cacheSize) {
        City removeCity = new City(0, "");
        for (City targetCity : cityList) {
            if(targetCity.getRecently() == cacheSize) {
                removeCity = targetCity;
                break;
            }
        }
        cityList.remove(removeCity);
    }

    private  void hitLRU(List<City> cityList, String city) {
        int targetRecently = 0;
        for (City targetCity : cityList) {
            if(targetCity.isSame(city)) {
                targetRecently = targetCity.getRecently();
                targetCity.hitFirst();
            }
        }
        for (City targetCity : cityList) {
            if(targetRecently > targetCity.getRecently() && !city.equals(targetCity.getCity())) {
                targetCity.increaseRecently();
            }
        }
    }

    private  boolean isContainCity(List<City> cityList, String city) {
        for (City targetCity : cityList) {
            if(targetCity.isSame(city)) {
                return true;
            }
        }
        return false;
    }

     class City {
        public int recently;
        public String city;

        public City(int recently, String city) {
            this.recently = recently;
            this.city = city;
        }

        public int getRecently() {
            return recently;
        }

        public String getCity() {
            return city;
        }

        public void increaseRecently() {
            recently++;
        }

        public boolean isSame(String city) {
            return city.equals(this.city);
        }

        public void hitFirst() {
            recently = 1;
        }
    }
}
