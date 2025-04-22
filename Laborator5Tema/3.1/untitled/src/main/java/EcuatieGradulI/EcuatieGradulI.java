package EcuatieGradulI;
import org.json.JSONObject;

public class EcuatieGradulI {

    public String rezolva(double a, double b) {
        JSONObject rezultat = new JSONObject();

        if (a == 0) {
            if (b == 0) {
                rezultat.put("situatie", "infinitate solutii");
            } else {
                rezultat.put("situatie", "nici o solutie");
            }
        } else {
            double x = -b / a;
            rezultat.put("situatie", "solutie_unica");
            rezultat.put("solutie", x);
        }

        return rezultat.toString(4); // Returnează șirul JSON formatat
    }
}