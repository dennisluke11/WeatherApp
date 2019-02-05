package com.example.boffinfundi.myweather;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.boffinfundi.myweather.MainService.RestClient;
import com.example.boffinfundi.myweather.MainService.ServiceMethods.MethodService;
import com.example.boffinfundi.myweather.Model.Weather;
import com.example.boffinfundi.myweather.Model.WeatherClass;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements LocationListener {

    TextView txtTemp, txtWeather,txtDay1,txtDay2,txtDay3,txtWeather1,txtWeather2,txtWeather3,txtMins,txtCurent,txtMax;
    ImageView txtImage1, txtImage2, txtImage3;
    String strDesctription1,strDescritpion2,strDescription3,strCity,strLongitude,strLatitude,strWeather,strDate1,strDate2,strDate3,strDate4,strDay;
    long dblCelsius,dblCelsius1,dblCelsius2,dblCelsius3;
    double dblFahrenheit,dbWeather1,dblWeather2,dblWeather3,dbMin,dbCurrent,dbMax;
    RelativeLayout layout,layout1;
    LocationManager locationManager;

    String myconstant="76de083f6b83ff87c5955eb068051afe";

    private java.util.List<com.example.boffinfundi.myweather.Model.List> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //mapping
      txtTemp=(TextView)findViewById(R.id.tv_temp);
      txtWeather=(TextView)findViewById(R.id.tv_weather);
      txtDay1=(TextView)findViewById(R.id.tv_day1);
      txtDay2=(TextView)findViewById(R.id.tv_days);
      txtDay3=(TextView)findViewById(R.id.tv_dayss);
      layout =(RelativeLayout)findViewById(R.id.mainLayout);
      layout1=(RelativeLayout)findViewById(R.id.mainLayout1);
      txtImage1=(ImageView) findViewById(R.id.tv_image1);
      txtImage2=(ImageView) findViewById(R.id.tv_image2);
      txtImage3=(ImageView) findViewById(R.id.tv_image3);
      txtWeather1=(TextView) findViewById(R.id.tv_weather1);
      txtWeather2=(TextView) findViewById(R.id.tv_weather2);
      txtWeather3=(TextView) findViewById(R.id.tv_weather3);
      txtMins=(TextView) findViewById(R.id.tv_mins);
      txtCurent=(TextView) findViewById(R.id.tv_curents);
      txtMax=(TextView) findViewById(R.id.tv_maxs);

        //Requesting Location permission
        if (ContextCompat.checkSelfPermission(getApplicationContext(), android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getApplicationContext(), android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION, android.Manifest.permission.ACCESS_COARSE_LOCATION}, 101);

        }

        //calling method to get Weather information from the API
        getLocation();



    }
       //RETROFIT request
    public void getWeather()
    {

        MethodService service = RestClient.getClient().create(MethodService.class);
        Call<WeatherClass> userCall = service.getWeather(strLatitude,strLongitude,myconstant);
        userCall.enqueue(new Callback<WeatherClass>() {
            @Override
            public void onResponse(Call<WeatherClass> call, Response<WeatherClass> response) {

                if(response.isSuccessful()==true) {
                  list= new ArrayList<com.example.boffinfundi.myweather.Model.List>();
                    list=response.body().getList();

                    //temperature information for the day
                    dblFahrenheit=list.get(0).getMain().getTemp();
                    dbMin=list.get(0).getMain().getTemp_min();
                    dbMax=list.get(0).getMain().getTemp_max();



                    //temperature information for the rest of the week
                    dbWeather1=list.get(8).getMain().getTemp();
                    dblWeather2=list.get(15).getMain().getTemp();
                    dblWeather3=list.get(22).getMain().getTemp();
                    strWeather=list.get(0).getWeather().get(0).getDescription().toString();


                    //dynamically changing the background information depending on the weather
                    if(strWeather.contains("clouds"))
                    {
                        layout.setBackgroundResource(R.drawable.cloudy);
                        layout1.setBackgroundColor(Color.parseColor("#54717A"));

                    }
                    else if(strWeather.contains("rain"))
                    {
                        layout.setBackgroundResource(R.drawable.rainy);
                        layout1.setBackgroundColor(Color.parseColor("#57575D"));
                    }
                    else if(strWeather.contains("sun"))
                    {
                        layout.setBackgroundResource(R.drawable.sunny);
                        layout1.setBackgroundColor(Color.parseColor("#1E90FF"));
                    }

                    else if(strWeather.contains("clear"))
                    {
                        layout.setBackgroundResource(R.drawable.sunny);
                        layout1.setBackgroundColor(Color.parseColor("#1E90FF"));
                    }


                    //ConvertKelvinCelsius
                    dblCelsius= (long) (dblFahrenheit-273.15F);
                    dblCelsius1=(long)(dbWeather1-273.15F);
                    dblCelsius2=(long)(dblWeather2-273.15F);
                    dblCelsius3=(long)(dblWeather3-273.15F);
                    dbMin=(long)(dbMin-273.15F);
                    dbMax=(long)(dbMax-273.15F);

                    //displaying all the temparature on Layout widgets
                    txtTemp.setText(String.valueOf(dblCelsius)+(char) 0x00B0);
                    txtCurent.setText(String.valueOf(dblCelsius)+(char) 0x00B0);
                    txtWeather1.setText(String.valueOf(dblCelsius1)+(char) 0x00B0);
                    txtWeather2.setText(String.valueOf(dblCelsius2)+(char) 0x00B0);
                    txtWeather3.setText(String.valueOf(dblCelsius3)+(char) 0x00B0);
                    txtMins.setText(String.valueOf(dbMin)+(char) 0x00B0);
                    txtCurent.setText(String.valueOf(dblCelsius)+(char) 0x00B0);
                    txtMax.setText(String.valueOf(dbMax)+(char) 0x00B0);
                    txtWeather.setText(strWeather);
                    strDate1=list.get(0).getDtTxt();
                    strDate2=list.get(8).getDtTxt();
                    strDesctription1=list.get(8).getWeather().get(0).getDescription();
                    strDate3=list.get(15).getDtTxt();
                    strDescritpion2=list.get(15).getWeather().get(0).getDescription();
                    strDate4=list.get(22).getDtTxt();
                    strDescription3=list.get(22).getWeather().get(0).getDescription();



                    //changing the image for the previous days depending on the weather
                    if(strDesctription1.contains("clouds"))
                    {
                        txtImage1.setBackgroundResource(R.drawable.partlysunny);
                    }
                    else if(strDesctription1.contains("rain"))
                    {
                        txtImage1.setBackgroundResource(R.drawable.rain);
                    }
                    else if(strDesctription1.contains("sun"))
                    {
                        txtImage1.setBackgroundResource(R.drawable.clear);
                    }

                    else if(strDesctription1.contains("clear"))
                    {
                        txtImage1.setBackgroundResource(R.drawable.clear);
                    }


                    if(strDescritpion2.contains("clouds"))
                    {
                        txtImage2.setBackgroundResource(R.drawable.partlysunny);
                    }
                    else if(strDescritpion2.contains("rain"))
                    {
                        txtImage2.setBackgroundResource(R.drawable.rain);
                    }
                    else if(strDescritpion2.contains("sun"))
                    {
                        txtImage2.setBackgroundResource(R.drawable.clear);
                    }

                    else if(strDescritpion2.contains("clear"))
                    {
                        txtImage2.setBackgroundResource(R.drawable.clear);
                    }



                    if(strDescription3.contains("clouds"))
                    {
                        txtImage3.setImageResource(R.drawable.partlysunny);
                    }
                    else if(strDescription3.contains("rain"))
                    {
                        txtImage3.setImageResource(R.drawable.rain);
                    }
                    else if(strDescription3.contains("sun"))
                    {
                        txtImage3.setImageResource(R.drawable.clear);
                    }
                    else if(strDescription3.contains("clear"))
                    {
                        txtImage3.setImageResource(R.drawable.clear);
                    }




                   //getting the dates from the Response JSON to get the day
                    String aa=strDate2.substring(0, strDate2.indexOf(" "));
                    String bb=strDate3.substring(0, strDate3.indexOf(" "));
                    String cc=strDate4.substring(0, strDate4.indexOf(" "));


                    String t1 = strDate2.substring(strDate2.indexOf(" ")+1);
                    t1.trim();

                    String t2 = strDate3.substring(strDate3.indexOf(" ")+1);
                    t1.trim();

                    String t3 = strDate4.substring(strDate4.indexOf(" ")+1);
                    t1.trim();



                    try {

                        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(aa);
                        Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(bb);
                        Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse(cc);
                        theDay(date);
                        txtDay1.setText(strDay+"\n"+t1);
                        theDay(date1);
                        txtDay2.setText(strDay+"\n"+t2);
                        theDay(date2);
                        txtDay3.setText(strDay+"\n"+t3);

                    } catch (ParseException e) {
                        e.printStackTrace();
                    }


                }
                else
                    {
                    Toast.makeText(getApplicationContext(), "server error", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<WeatherClass> call, Throwable t)
            {

                Toast.makeText(getApplicationContext(),"Oops! There was a problem with your request. Please check your connection or try again later",Toast.LENGTH_LONG).show();
            }
        });
    }

    void getLocation() {
        try {
            locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 5000, 5, (LocationListener) this);
        }
        catch(SecurityException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onLocationChanged(Location location) {
        try {
            Geocoder geocoder = new Geocoder(this, Locale.getDefault());
            strLongitude = String.valueOf(location.getLongitude());
            strLatitude= String.valueOf(location.getLatitude());

            getWeather();




        }catch(Exception e)
        {

        }

    }

    @Override
    public void onProviderDisabled(String provider) {

        Toast.makeText(MainActivity.this, "Please Enable GPS and Internet", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }




//method to get the day of the week depending on the date
public void theDay(Date date)
{
    Calendar c = Calendar.getInstance();
    c.setTime(date);
    int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
    if(dayOfWeek==1)
    {
        strDay="Sunday";
    }
    else if(dayOfWeek==2)

    {
        strDay="Monday";
    }
    else if(dayOfWeek==3)
    {
        strDay="Tuesday";
    }
    else if(dayOfWeek==4)
    {
        strDay="Wednesday";
    }
    else if(dayOfWeek==5)
    {
        strDay="Thursday";
    }
    else if(dayOfWeek==6)
    {
        strDay="Friday";
    }
    else if(dayOfWeek==7)
    {
        strDay="Saturday";
    }


}



}
