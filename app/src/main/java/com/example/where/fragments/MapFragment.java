package com.example.where.fragments;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.example.where.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import android.support.v4.app.*;

import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.EasyPermissions;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MapFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MapFragment extends Fragment implements OnMapReadyCallback {
    GoogleMap map;
    private MapView mapView;
    SupportMapFragment mapFragment;
    int LOCATION_PERMISSION_REQUEST_CODE = 100;
    private final int REQUEST_LOCATION_PERMISSION = 1;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MapFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NotificationFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MapFragment newInstance(String param1, String param2) {
        MapFragment fragment = new MapFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_map, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        SupportMapFragment supportMapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        supportMapFragment.getMapAsync(this);
        requestLocationPermission();
    }

    //Autorisation position.
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        // Forward results to EasyPermissions
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }

    @AfterPermissionGranted(REQUEST_LOCATION_PERMISSION)
    public void requestLocationPermission() {
        String[] perms = {Manifest.permission.ACCESS_FINE_LOCATION};
        if (EasyPermissions.hasPermissions(getActivity(), perms)) {
            Toast.makeText(getActivity(), "Permission already granted", Toast.LENGTH_SHORT).show();

        } else {
            EasyPermissions.requestPermissions(this, "Please grant the location permission", REQUEST_LOCATION_PERMISSION, perms);
        }
    }


    //Map Api
    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;

        //Lieux
        LatLng AeroportR = new LatLng(-20.894131, 55.508253);
        LatLng Bout0 = new LatLng(-20.886013, 55.456623);
        LatLng Bout1 = new LatLng(-20.875147, 55.452932);
        LatLng Bout3 = new LatLng(-20.882044, 55.460614);
        LatLng Bout5 = new LatLng(-20.916283, 55.460492);

        LatLng Bout2 = new LatLng(-20.931888, 55.334069);
        LatLng Bout4 = new LatLng(-20.942750, 55.330679);






        //ajout
        map.addMarker(new MarkerOptions().position(AeroportR).title("Aeroport de La Reunion Roland Garros"));
        map.addMarker(new MarkerOptions().position(Bout0).title("Boutique 0").snippet("La vida loca"));
        map.addMarker(new MarkerOptions().position(Bout1).title("Boutique 1").snippet("Fruits et Légumes"));
        map.addMarker(new MarkerOptions().position(Bout3).title("Boutique 3").snippet("Fruits et Légumes"));
        map.addMarker(new MarkerOptions().position(Bout5).title("Boutique 5").snippet("Fruits et Légumes"));
        map.addMarker(new MarkerOptions().position(Bout2).title("Boutique 2").snippet("Fruits et Légumes"));
        map.addMarker(new MarkerOptions().position(Bout4).title("Boutique 4").snippet("Fruits et Légumes"));









        //default location
        map.moveCamera(CameraUpdateFactory.newLatLng(AeroportR));
        map.animateCamera(CameraUpdateFactory.zoomTo(10));

        //setting
        map.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        map.setTrafficEnabled(true);
        map.setIndoorEnabled(true);
        map.setBuildingsEnabled(true);
        map.getUiSettings().setZoomControlsEnabled(true);

        //check location permission
        if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.

            return;
        }
        map.setMyLocationEnabled(true);




    }
}
