package Modelo;

import android.text.AndroidCharacter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import util.AndroidUtils;

/**
 * Created by CTN Developer on 28-07-2016.
 */
public class ColegioTx {
    private String url;

    public ColegioTx() {
        this.url = null;
    }

    public ColegioTx(String url) {
        this.url = url;
    }

    public List<Colegio> getAll(){
        List<Colegio> colegiosList = new ArrayList<>();
        JSONArray jsonArray;
        try{
            String jsonString = AndroidUtils.getDataStringByURL(this.url);
            JSONObject jsonObj = new JSONObject(jsonString);
            jsonArray = jsonObj.getJSONArray("data"); // OBTENER EL ARREGLO JSON

            for(int i = 0; i<jsonArray.length(); i++){
                JSONObject o    = jsonArray.getJSONObject(i);
                Colegio nuevo;
                if(o.has("latitude") && o.has("longitude")){
                    nuevo = new Colegio(o.getInt("id"),o.getString("name"),o.getString("address"),o.getDouble("latitude"),o.getDouble("longitude"));
                }else{
                    nuevo = new Colegio(o.getInt("id"),o.getString("name"),o.getString("address"),0.0,0.0);
                }

                colegiosList.add(nuevo);
            }
        }catch (JSONException e){
            e.printStackTrace();
        }

        return colegiosList;
    }




    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
