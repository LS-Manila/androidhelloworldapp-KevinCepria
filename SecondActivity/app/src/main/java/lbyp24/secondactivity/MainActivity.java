package lbyp24.secondactivity;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
    private String k;
    private String temp, message;
    private int month,day,year,century,DAY;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        firstscreen();
    }
     private void firstscreen(){
         setContentView(R.layout.activity_main);
         Button compute=(Button) findViewById(R.id.button);
         compute.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 StoreData();
                 ComputeDate();
                 GetDay();
                secondScreen();
             }
         });
     }
    private void ComputeDate(){

       DAY = (day + (int)(26 *(month + 1)/10.0) + year + (int)(year/4.0) + (int)(century/4.0) + 5 * century ) % 7;
    }

    private void StoreData(){
         EditText input_day=(EditText) findViewById(R.id.EditText);
         EditText input_month=(EditText) findViewById(R.id.EditText1);
         EditText input_year=(EditText) findViewById(R.id.EditText2);
        try {
            day = Integer.parseInt(input_day.getText().toString());
        }
        catch (Exception e){
            day = 0;
        }

        try {
            month = Integer.parseInt(input_month.getText().toString());
        }
        catch (Exception e){
            month = 0;
        }

        try {
            temp = input_year.getText().toString();
            year = Integer.parseInt(temp.substring(2));
            century =  Integer.parseInt(temp.substring(0,2));
        }
        catch (Exception e){
            year = 0;
            century = 0;
        }

        if (month == 1 || month == 2) {
            month += 12;
            year--;
        }
    }
  private void secondScreen(){
      setContentView(R.layout.secondscreen);
      TextView a=(TextView)findViewById(R.id.textView1);
       TextView b=(TextView)findViewById(R.id.textView2);
      Button back=(Button) findViewById(R.id.button1);
      a.setText(message);
      b.setText(k);
      back.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              firstscreen();
          }
      });
  }
    private void GetDay(){
        switch(DAY){
            case 0:
                message="SATURDAY!";
                k="YEY WEEKEND! :)";
                break;
            case 1:
                message="SUNDAY!";
                k="YEY WEEKEND! :)";
                break;
            case 2:
                message="MONDAY!";
                k=" TOO BAD! :(";
                break;
            case 3:
                message="TUESDAY!";
                k="BE PRODUVTIVE! :)";
                break;
            case 4:
                message="WEDNESDAY!";
                k=" ENJOY! :)";
                break;
            case 5:
                message="THURSDAY!";
                k="DON'T SLACK OFF! :)";
                break;
            case 6:
                message="FRIDAY!";
                k="YEY FRIDAY! :)";
                break;
            default:
                message="INVALID DAY! THAT IS SUPER WEIRD";
                break;
        }


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
