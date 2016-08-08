package Modelo;

import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by CTN Developer on 07-08-2016.
 */
public class ColegioTransporte {
    int colegioId;
    Colegio colegioActivo;
    ArrayList<Colegio> colegios = new ArrayList<>();
    Map<String,Colegio> lista = new HashMap<String, Colegio>();;
    int hayObjetoColegioActivo = 0;
    TextView mTextView1;
    TextView mtextoMapaDireccion;
    TextView mtextoMapaTelefono;
    int hayCampoMapa = 0;

    int buscoColegios=0;




    public TextView getMtextoMapaTelefono() {
        return mtextoMapaTelefono;
    }

    public void setMtextoMapaTelefono(TextView mtextoMapaTelefono) {
        this.mtextoMapaTelefono = mtextoMapaTelefono;
    }

    public TextView getMtextoMapaDireccion() {
        return mtextoMapaDireccion;
    }

    public void setMtextoMapaDireccion(TextView mtextoMapaDireccion) {
        this.mtextoMapaDireccion = mtextoMapaDireccion;
    }

    GoogleMap mGoogleMap;
    int hayGoogleMap =0;


    public GoogleMap getmGoogleMap() {
        return mGoogleMap;
    }

    public void setmGoogleMap(GoogleMap mGoogleMap) {
        this.mGoogleMap = mGoogleMap;
    }

    public int getHayGoogleMap() {
        return hayGoogleMap;
    }

    public void setHayGoogleMap(int hayGoogleMap) {
        this.hayGoogleMap = hayGoogleMap;
    }

    public TextView getmTextView1() {
        return mTextView1;
    }

    public void setmTextView1(TextView mTextView1) {
        this.mTextView1 = mTextView1;
    }

    public int getHayObjetoColegioActivo() {
        return hayObjetoColegioActivo;
    }

    public void setHayObjetoColegioActivo(int hayObjetoColegioActivo) {
        this.hayObjetoColegioActivo = hayObjetoColegioActivo;
    }

    public int getHayCampoMapa() {

        return hayCampoMapa;
    }

    public void setHayCampoMapa(int hayCampoMapa) {
        this.hayCampoMapa = hayCampoMapa;
    }

    public ColegioTransporte() {
        Colegio colegioNuevo = new Colegio(0,"ESCUELA CARLOS GUIRAO MASSIF","Direccion "+0,-18.48379188,-70.30008008);
        colegioNuevo.setPhone("+56582221809");
        this.agregaColegioFull(0,colegioNuevo);

        for (int i=1; i<10;i++){
            colegioNuevo = new Colegio(i,"Colegio "+i,"Direccion "+i,-34.00,151.0);
            colegioNuevo.setPhone("+56582221809");
            this.agregaColegioFull(i,colegioNuevo);
        }
    }

    public void agregaColegioFull(int i,Colegio colegioNuevo){
        this.colegios.add(colegioNuevo);
        this.lista.put("c"+i,colegioNuevo);

    }

    public int getColegioId() {
        return colegioId;
    }

    public Colegio getColegioFromIndice(int indice){
        return this.lista.get("c"+indice);
    }




    public void setColegioId(int colegioId) {
        this.colegioId = colegioId;
    }

    public Colegio getColegioActivo() {
        return colegioActivo;
    }

    public void setColegioActivo(Colegio colegioActivo) {
        hayObjetoColegioActivo = 1;
        this.colegioActivo = colegioActivo;
    }



    public ArrayList<Colegio> getColegios() {
        return colegios;
    }

    public void setColegios(ArrayList<Colegio> colegios) {
        this.colegios = colegios;
    }
}
