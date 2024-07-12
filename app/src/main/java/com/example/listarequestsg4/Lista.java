package com.example.listarequestsg4;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.listarequestsg4.Modelos.ApiMethods;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Lista extends AppCompatActivity {
    private RequestQueue Queue;
    private ListView listView;
    private ArrayAdapter<String> adp;
    private List<String> Arreglo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lista);

        listView = findViewById(R.id.listareq);
        Arreglo = new ArrayList<>();
        adp = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Arreglo);
        listView.setAdapter(adp);

        RellenarDatos();
    }

    private void RellenarDatos() {
        Queue = Volley.newRequestQueue(this);
        JsonArrayRequest Req = new JsonArrayRequest(Request.Method.GET, ApiMethods.Endpoint1, null,
                response -> {
                    try {
                        for (int i = 0; i < response.length(); i++) {
                            JSONObject post = response.getJSONObject(i);
                            String id = post.getString("id");
                            String title = post.getString("title");
                            String body = post.getString("body");
                            String data = "Id= " +id+
                                    "\n Title= "+title+
                                    "\n Body= "+body+"\n";
                            Arreglo.add(data);
                        }
                        adp.notifyDataSetChanged();
                    } catch (JSONException e) {
                        Log.i("Error", "onResponse: "+ e.toString());
                    }
                }, e -> Log.i("Error", "onErrorResponse: "+ e.toString()));
        Queue.add(Req);
    }
}