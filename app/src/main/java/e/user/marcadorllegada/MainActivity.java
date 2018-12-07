package e.user.marcadorllegada;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    public Button btn;
    public TextView txt;
    public TextView txtPersona;
    public ArrayList<Integer> list;
    public Date hora;
    public Date horaInicioAM;
    public Date horaFinAM ;
    public Date horaFinDia;
    public Date horaUsuario;
    public Date horaSalidaInicio;
    public Date horaSalidaFin;
    public Date horaInicioDia;
    public SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm:ss");

    public void Registro(Date horaInicioAM,Date horaFinAM, Date horaUsuario,Date horaSalidaInicio, Date horaSalidaFin, Date horaFinDia, Date horaInicioDia){


        if(horaUsuario.before(horaInicioAM)){
            if(horaUsuario.after(horaInicioDia)){
            Toast.makeText(MainActivity.this,"No se puede registrar a esta hora1", Toast.LENGTH_LONG).show(); //mala hora
                return;}
        }
        if(horaUsuario.before(horaFinDia)){
            if(horaUsuario.after(horaSalidaFin)&&horaUsuario.before(horaFinDia)){
            Toast.makeText(MainActivity.this,"No se puede registrar a esta hora2", Toast.LENGTH_LONG).show(); //mala hora
            return;}
        }
        if(horaUsuario.after(horaInicioAM)){
            if(horaUsuario.before(horaFinAM)){
                Toast.makeText(MainActivity.this,"Se registró a la hora", Toast.LENGTH_LONG).show(); //a tiempo
                return;
            }}
        if(horaUsuario.after(horaFinAM)){
            if(horaUsuario.before(horaSalidaInicio)){
                Toast.makeText(MainActivity.this,"Se registró tardanza", Toast.LENGTH_LONG).show(); //tarde
                return;
            }
        }
        if(horaUsuario.after(horaSalidaInicio)){
            if(horaUsuario.before(horaSalidaFin)){
                Toast.makeText(MainActivity.this, "Se registró salida", Toast.LENGTH_LONG).show(); //salida
                return;
            }
        }




           //Toast.makeText(MainActivity.this,"Se registró a la hora", Toast.LENGTH_LONG).show(); //a tiempo

           //Toast.makeText(MainActivity.this,"Se registró tardanza", Toast.LENGTH_LONG).show(); //tarde

           //Toast.makeText(MainActivity.this, "Se registró salida", Toast.LENGTH_LONG).show(); //salida

           //Toast.makeText(MainActivity.this,"No se puede registrar a esta hora", Toast.LENGTH_LONG).show(); //mala hora

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt = findViewById(R.id.txtHora);
        btn = findViewById(R.id.btnLogin);
        txtPersona = findViewById(R.id.txtUsuario);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    hora = Calendar.getInstance().getTime();
                    String prueba = simpleDateFormat.format(hora);
                    horaUsuario = simpleDateFormat.parse(prueba);

                    String p2 =  simpleDateFormat.format(simpleDateFormat.parse(("07:59:59")));
                    horaInicioAM = simpleDateFormat.parse(p2);
                    //String pruebasa = horaInicioAM.toString()/11;
                    Log.i("MEME", horaInicioAM.toString());
                    String p3 = simpleDateFormat.format(simpleDateFormat.parse(("08:59:59")));
                    horaFinAM = simpleDateFormat.parse(p3);
                    String p5 = simpleDateFormat.format((simpleDateFormat.parse("17:59:59")));
                    horaSalidaInicio = (simpleDateFormat).parse(p5);
                    String p6 = simpleDateFormat.format(simpleDateFormat.parse("19:59:50"));
                    horaSalidaFin = (simpleDateFormat).parse(p6);
                    String p7 = simpleDateFormat.format((simpleDateFormat).parse("23:59:59"));
                    horaFinDia = (simpleDateFormat).parse(p7);
                    String p8 = simpleDateFormat.format((simpleDateFormat).parse("00:00:01"));
                    horaInicioDia = (simpleDateFormat).parse(p8);



                    //Log.i("INFOTPM",(horaUsuario.after(horaSalidaFin))+"");
                    //Log.i("INFOTAM",(horaUsuario.before(horaInicioAM))+"");
                    //Log.i("INFOTARDP", (horaUsuario.before(horaSalidaInicio))+"");
                    Log.i("INFOINV1",(((horaUsuario.before(horaInicioAM))&&(horaUsuario.after(horaInicioDia))))+"");
                    Log.i("INFOINV2",((horaUsuario.after(horaSalidaFin))&&(horaUsuario.before(horaFinDia)))+"");
                    Log.i("INFOINV3",horaUsuario.after(horaSalidaFin)+"");
                    Log.i("INFOINV3.5",horaSalidaFin.after(horaUsuario)+"");
                    Log.i("INFOINV4",horaUsuario.before(horaFinDia)+"");
                    Log.i("INFOOK",((horaUsuario.after(horaInicioAM))&&(horaUsuario.before(horaFinAM)))+"");
                    Log.i("INFOTARDA",((horaUsuario.after(horaInicioAM))&&(horaUsuario.before(horaSalidaInicio)))+"");
                    Log.i("INFOOUTOK",((horaUsuario.after(horaSalidaInicio))&&(horaUsuario.before(horaSalidaFin)))+"");

                    Registro((Date)horaInicioAM,
                            (Date)horaFinAM,
                            (Date)horaUsuario,
                            (Date)horaSalidaInicio,
                            (Date)horaSalidaFin,
                            (Date) horaFinDia,
                            (Date) horaInicioDia);



                } catch (Exception e) {
                    e.printStackTrace();
                    Log.e("Falla: ", e.toString());
                }


            }
        });

    }
}
