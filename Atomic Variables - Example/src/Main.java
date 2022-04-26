import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class Main {

    private static Map<String, Double> pricesByAirline;

    public static void main(String[] args)  {
        init();

        String from = "BCN";
        String to = "JFK";

        Double lowestPrice = getLowestPrice(from, to);
        Double avgPrice = getAvgPrice(from, to);

        System.out.println("Lowest Price: " + lowestPrice);
        System.out.println("Avg Price: " + avgPrice);
    }

    private static Double getLowestPrice(String from, String to) {
        AtomicReference<Double> lowestPrice = new AtomicReference<>(null);

        pricesByAirline.keySet().stream().parallel().forEach(airline -> {
            Double price = getPriceTrip(airline, from, to);
            if (lowestPrice.get() == null || price < lowestPrice.get()) {
                lowestPrice.set(price);
            }
        });
        return lowestPrice.get();
    }

    private static Double getAvgPrice(String from, String to) {
        AtomicReference<Double> sumPrice = new AtomicReference<>(0.0);
        pricesByAirline.keySet().stream().parallel().forEach(airline -> {
            Double price = getPriceTrip(airline, from, to);
            Double result = sumPrice.get() + price;
            sumPrice.set(result);
        });

        int countAirlines = pricesByAirline.keySet().size();
        return sumPrice.get() / countAirlines;
    }

    private static void init() {
        pricesByAirline = new HashMap<>();
        pricesByAirline.put("American Airlines", 550.0);
        pricesByAirline.put("US Airways", 610.0);
        pricesByAirline.put("Delta Airlines", 540.0);
        pricesByAirline.put("Singapore Airlines", 612.0);
        pricesByAirline.put("Qatar Airways", 590.0);
        pricesByAirline.put("Cathay Pacific Airways", 585.0);
        pricesByAirline.put("Sky Airline", 540.0);
        pricesByAirline.put("Copa Airlines Colombia", 610.0);
        pricesByAirline.put("Avianca", 580.0);
        pricesByAirline.put("LATAM Airlines Group", 600.0);
        pricesByAirline.put("Aeroméxico", 740.0);
        pricesByAirline.put("Aerolíneas Argentinas", 940.0);
    }

    private static Double getPriceTrip(String airline, String from, String to) {


        return pricesByAirline.get(airline);
    }
}
