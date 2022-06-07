package com.example.ex3json;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Spinner s;
    ArrayList<Employe> employees;
    TextView tnom,tmat,tfon,tnaiss,tsal;
    RadioGroup rg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        s=findViewById(R.id.sp);
        tnom=findViewById(R.id.tnom);
        tmat=findViewById(R.id.tmat);
        tfon=findViewById(R.id.tfonction);
        rg=findViewById(R.id.rgenre);
        tnaiss=findViewById(R.id.tnais);
        tsal=findViewById(R.id.tsal);
        employees=getAllemplys();

        ArrayList<String> nomEmps= new ArrayList<>();

        for(Employe e:employees){
            nomEmps.add(e.getNom());
        }

        ArrayAdapter ad = new ArrayAdapter(this, android.R.layout.simple_list_item_1,nomEmps);
        s.setAdapter(ad);

        s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Employe ee = employees.get(i);
                tnom.setText("Nom : " + ee.getNom());
                tmat.setText("Matricule : " +ee.getMatricule());
                tfon.setText("Fonction : " +ee.getFonction());
                tnaiss.setText("Naissance : " +ee.getNaissance());
                tsal.setText("Salaire : " +String.valueOf(ee.getSalaire()));

                if(ee.getGenre().equalsIgnoreCase("Homme")){
                    rg.check(R.id.r1);
                }
                else{
                    rg.check(R.id.r2);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
    public String loadJsonFromRaw(int resId) {

        try {
            InputStream in = getResources().openRawResource(resId);
            byte[] data = new byte[in.available()];
            in.read(data);
            in.close();
            return new String(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    public ArrayList<Employe> getAllemplys() {
        ArrayList<Employe> emp = new ArrayList<>();

        try {
            String json = loadJsonFromRaw(R.raw.employees);
            JSONArray arr = new JSONArray(json);

            for (int i = 0; i < arr.length(); i++) {
                JSONObject o = arr.getJSONObject(i);
                Employe s = new Employe();
                s.setNom(o.getString("nom"));
                s.setMatricule(o.getString("matricule"));
                s.setGenre(o.getString("genre"));
                s.setFonction(o.getString("fonction"));
                s.setNaissance(o.getString("naissance"));
                s.setSalaire(o.getDouble("salaire"));
                emp.add(s);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return emp;
    }
}