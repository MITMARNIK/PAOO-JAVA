package org.example.Config;

import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Config {

    private static Config instance;
    private String culoare;
    private Integer weight;
    private boolean dataLoadedCuloare = false;
    private boolean dataLoadedWeight = false;
    private final String configFilePath = "config.json";

    private Config() {
    }

    public static Config getInstance() {
        if (instance == null) {
            instance = new Config();
        }
        return instance;
    }

    public String getCuloare() {
        loadConfigCuloare();
        return culoare;
    }

    public Integer getWeight() {
        loadConfigWeight();
        return weight;
    }

    private void loadConfigCuloare() {
        if (!dataLoadedCuloare) {
            try {
                String content = new String(Files.readAllBytes(Paths.get(configFilePath)));
                JSONObject jsonObject = new JSONObject(content);
                this.culoare = jsonObject.getString("culoare");
                this.dataLoadedCuloare = true;
                System.out.println("Culoarea a fost citita din fisier.");
            } catch (IOException e) {
                System.err.println("Eroare la citirea fisierului: " + e.getMessage());
                this.culoare = "#FFFFFF"; // Valoare implicită
                this.dataLoadedCuloare = true;
            }
        } else {
            System.out.println("Culoarea a fost deja incarcata.");
        }
    }

    private void loadConfigWeight() {
        if (!dataLoadedWeight) {
            try {
                String content = new String(Files.readAllBytes(Paths.get(configFilePath)));
                JSONObject jsonObject = new JSONObject(content);
                this.weight = jsonObject.getInt("weight");
                this.dataLoadedWeight = true;
                System.out.println("Weight a fost citita din fisier.");
            } catch (IOException e) {
                System.err.println("Eroare la citirea fisierului: " + e.getMessage());
                this.weight = 20; // Valoare implicită
                this.dataLoadedWeight = true;
            }
        } else {
            System.out.println("Weight a fost deja incarcata.");
        }
    }
}