package com.example.codebuss.thisismyweather

import android.content.pm.PackageManager
import android.location.Location
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.app.ActivityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.codebuss.thisismyweather.bussiness.model.DailyWeatherModel
import com.example.codebuss.thisismyweather.bussiness.model.HourlyWeatherModel
import com.example.codebuss.thisismyweather.bussiness.model.WeatherData
import com.example.codebuss.thisismyweather.databinding.ActivityMainBinding
import com.example.codebuss.thisismyweather.presenters.MainPresenter
import com.example.codebuss.thisismyweather.view.MainView
import com.example.codebuss.thisismyweather.view.adapters.MainDailyListAdapter
import com.example.codebuss.thisismyweather.view.adapters.MainHourlyListAdapter
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult
import com.google.android.gms.location.LocationServices
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.android.synthetic.main.activity_main.*
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter
import org.w3c.dom.ls.LSException
import java.util.jar.Manifest
import kotlin.math.log

const val GEO_LOCATION_REQUEST_COD_SUCCESS = 1

class MainActivity : MvpAppCompatActivity(), MainView {

    lateinit var bindingMain: ActivityMainBinding

    private val mainPresenter by moxyPresenter { MainPresenter() }

    private val geoService by lazy { LocationServices.getFusedLocationProviderClient(this) }
    private val locationRequest by lazy { initLocationRequest() }
    private lateinit var mLocation: Location

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingMain = ActivityMainBinding.inflate(layoutInflater).also { setContentView(it.root) }

        checkPermission()
        initializeListRecyclerView()

        mainPresenter.enable()

        geoService.requestLocationUpdates(locationRequest, geoCallback, null)
    }

    private fun initViews() {
        main_citi_name.text = "Кропивницкий"
        main_day_data.text = "30 августа"
        main_weather_condition_icon.setImageResource(R.drawable.ic_sun)
        main_temp.text = "25\u00B0"
        main_temp_min.text = "19"
        main_temp_max.text = "25"
        main_image_of_weather.setImageResource(R.mipmap.cloud3x)
        main_pressure_text.text
        main_humidity_text.text
        main_wind_text.text
        main_time_sun_up.text
        main_time_sun_dn.text
    }


    // ---------------- location code _____________

    private fun initLocationRequest(): LocationRequest {
        val request = LocationRequest.create()
        return request.apply {
            interval = 10000
            fastestInterval = 5000
            priority = LocationRequest.PRIORITY_HIGH_ACCURACY
        }
    }

    private val geoCallback = object : LocationCallback() {
        override fun onLocationResult(geo: LocationResult) {
            for (location in geo.locations) {
                mLocation = location
                mainPresenter.refresh(mLocation.latitude.toString(), mLocation.longitude.toString())
            }
        }
    }

    // ----- initial activity code


    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {

        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

    private fun checkPermission() {
        if (ActivityCompat.checkSelfPermission(
                this,
                android.Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED &&
            ActivityCompat.checkSelfPermission(
                this,
                android.Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            MaterialAlertDialogBuilder(this)
                .setTitle("Нам нужні его данніе")
                .setMessage("Разрешите доступ к гео данным")
                .setPositiveButton("ok") { _, _ ->
                    ActivityCompat.requestPermissions(
                        this,
                        arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION),
                        GEO_LOCATION_REQUEST_COD_SUCCESS
                    )
                    ActivityCompat.requestPermissions(
                        this,
                        arrayOf(android.Manifest.permission.ACCESS_COARSE_LOCATION),
                        GEO_LOCATION_REQUEST_COD_SUCCESS
                    )
                }
                .setNegativeButton("cansel") { dialog, _ -> dialog.dismiss() }
                .create()
                .show()
        }

    }

    // ---------------- location code _____________

    private fun initializeListRecyclerView() {
        bindingMain.mainHourlyList.apply {
            adapter = MainHourlyListAdapter() // Отвечает за расположение обьекта
            // динамическое изминение размеров обьекта откулючино
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            // Установить фиксированный размер
            setHasFixedSize(true)
        }
        bindingMain.mainDailyList.apply {
            adapter = MainDailyListAdapter()
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            setHasFixedSize(true)
        }
    }

    // Moxy-----
    override fun displayLocation(data: String) {
        bindingMain.mainCitiName.text = data
    }

    override fun displayCurrentDatta(data: WeatherData) {
        main_citi_name.text = "Кропивницкий"
        main_day_data.text = "30 августа"
        main_weather_condition_icon.setImageResource(R.drawable.ic_sun)
        main_temp.text = "25\u00B0"
        main_temp_min.text = "19"
        main_temp_max.text = "25"
        main_image_of_weather.setImageResource(R.mipmap.cloud3x)
        main_pressure_text.text
        main_humidity_text.text
        main_wind_text.text
        main_time_sun_up.text
        main_time_sun_dn.text

    }

    override fun displayHourlyData(data: List<HourlyWeatherModel>) {
        (bindingMain.mainHourlyList.adapter as MainHourlyListAdapter).updateData(data)
    }

    override fun displayDailyData(data: List<DailyWeatherModel>) {
        (bindingMain.mainDailyList.adapter as MainDailyListAdapter).updateData(data)

    }

    override fun displayError(error: Throwable) {

    }

    override fun setLocation(flag: Boolean) {

    }

    // Moxy-----

}