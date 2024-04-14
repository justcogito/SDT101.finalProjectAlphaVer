package SDT101.project2.catalogs;

import SDT101.project2.classes.MeasurementUnit;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class MeasurementUnits {

    private static ArrayList<MeasurementUnit> measurementUnits = new ArrayList<MeasurementUnit>();

    {
//        importMeasurementUnits();
    }

    public static void importMeasurementUnits() {
        measurementUnits.clear();
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader("measurementUnits"))) {
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                int id = Integer.parseInt(parts[0]);
                String name = parts[2];
                String abbreviation = parts[1];
                MeasurementUnit unit = new MeasurementUnit(id, name, abbreviation);
                measurementUnits.add(unit);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<MeasurementUnit> getMeasurementUnits() {
        return measurementUnits;
    }

    public static MeasurementUnit getMeasurementById(int id) {
        for (MeasurementUnit unit : measurementUnits) {
            if (unit.id == id) {
                return unit;
            }
        }
        return null;
    }

}
