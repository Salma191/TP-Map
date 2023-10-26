package ma.ensa.localisation;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private List<LatLng> positions = new ArrayList<>();
    RequestQueue requestQueue;
    String showUrl = "http://192.168.248.43/Map/showPositions.php";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        requestQueue = Volley.newRequestQueue(getApplicationContext());
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Appelez la méthode pour ajouter des marqueurs statiques
        setUpMap();
    }

    public void setUpMap() {
        LatLng position1 = new LatLng(33.593098, -7.640526);
        mMap.addMarker(new MarkerOptions().position(position1).title("Tour Eiffel"));

        LatLng position2 = new LatLng(33.518172, -7.744292);
        mMap.addMarker(new MarkerOptions().position(position2).title("Times Square"));
        LatLng position3 = new LatLng(33.729116, -7.020240);
        mMap.addMarker(new MarkerOptions().position(position3).title("Times Square"));


        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(position1, 12));
    }
}