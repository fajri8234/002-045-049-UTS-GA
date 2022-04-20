package com.example.a002045049utsga;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.a002045049utsga.R;
import com.example.a002045049utsga.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        gantiFragment(new LokasiSaatIniFragment());
        binding.judul.setText(getString(R.string.lokasi));
        binding.bottomNavigationView.setOnItemSelectedListener(item -> {

            switch (item.getItemId()){
                case R.id.lsi:
                    gantiFragment(new LokasiSaatIniFragment());
                    binding.judul.setText(getString(R.string.lokasi));
                    break;
                case R.id.pl:
                    gantiFragment(new PencarianLokasiFragment());
                    binding.judul.setText(getString(R.string.pencarian));
                    break;
                case R.id.tls:
                    gantiFragment(new TitikLokasiSekarangFragment());
                    binding.judul.setText(getString(R.string.titik));
                    break;
            }

            return true;
        });
    }

    private void gantiFragment (Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }
}