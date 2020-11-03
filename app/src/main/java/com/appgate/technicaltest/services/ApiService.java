package com.appgate.technicaltest.services;

import android.content.Context;
import android.os.StrictMode;

import com.appgate.technicaltest.R;
import com.appgate.technicaltest.data.AppContext;
import com.appgate.technicaltest.services.Models.Api;
import com.appgate.technicaltest.services.Models.ApiRequest;
import com.appgate.technicaltest.services.Models.ParameterHeader;

import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiService<T> implements IApiService {
    Context context;
    private int timeout = 20000;

    public ApiService(){
        this.context = AppContext.getAppContext();
    }

    public String Execute(ApiRequest apiRequest) throws Exception {
        try {
            String modelResponse = null;
            String urlApi = GetUrlService(apiRequest.getApi());
            String endPointComplete = urlApi + apiRequest.getEndPoint();

            if (apiRequest.getPathParameters() != null) {
                for (ParameterHeader pathParameter : apiRequest.getPathParameters()) {
                    endPointComplete = endPointComplete + pathParameter.getValue() + "/";
                }
            }

            if (apiRequest.getQueryParameters() != null) {
                endPointComplete = endPointComplete + "?";
                for (ParameterHeader pathParameter : apiRequest.getQueryParameters()) {
                    endPointComplete = endPointComplete + pathParameter.getKey() + "=" + pathParameter.getValue() + "&";
                }
                endPointComplete = endPointComplete.substring(0, endPointComplete.length() - 1) + "";
            }

            switch (apiRequest.getTypeRequest()) {
                case GET:
                    modelResponse = Get(apiRequest, endPointComplete);
                    break;
                case PUT:
                    modelResponse = Put(apiRequest, endPointComplete);
                    break;
                case POST:
                    modelResponse = Post(apiRequest, endPointComplete);
                    break;
                case DELETE:
                    modelResponse = Delete(apiRequest, endPointComplete);
                    break;
            }
            return modelResponse;
        }
        catch (Exception ex){
            throw new Exception(ex.getMessage());
        }
    }

    private String GetUrlService(Api api)
    {
        String urlApi = "";//Obtener Ip a partir de configuración
        switch (api) {
            case GEONAMES:
                urlApi = context.getResources().getString(R.string.url_api_service_geonames);
                break;
        }
        return urlApi;
    }

    private String Get(ApiRequest apiRequest, String urlService) throws Exception {
        try {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            HttpURLConnection.setFollowRedirects(true); // defaults to true
            URL request_url = new URL(urlService);
            HttpURLConnection http_conn = (HttpURLConnection) request_url.openConnection();
            http_conn.setRequestMethod("GET");
            http_conn.setConnectTimeout(timeout);
            http_conn.setReadTimeout(timeout);
            http_conn.setInstanceFollowRedirects(true);
            http_conn.setRequestProperty("Content-Type", "application/json");
            System.out.println(String.valueOf(http_conn.getResponseCode()));
            BufferedReader in = new BufferedReader(new InputStreamReader(http_conn.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            JSONObject jsonObject = new JSONObject(response.toString());
            return jsonObject.toString();
        }
        catch (Exception ex)
        {
            throw new Exception(ex.getMessage());
        }
    }

    private String Post(ApiRequest apiRequest, String urlService) throws Exception {
        try
        {
            HttpURLConnection.setFollowRedirects(true); // defaults to true
            URL request_url = new URL(urlService);
            HttpURLConnection http_conn = (HttpURLConnection)request_url.openConnection();
            http_conn.setConnectTimeout(timeout);
            http_conn.setReadTimeout(timeout);
            http_conn.setInstanceFollowRedirects(true);
            http_conn.setDoOutput(true);
            PrintWriter out = new PrintWriter(http_conn.getOutputStream());
            out.close();

            InputStream in = new BufferedInputStream(http_conn.getInputStream());
            //String result = org.apache.commons.io.IOUtils.toString(in, "UTF-8");
            JSONObject jsonObject = new JSONObject(in.toString());
            return jsonObject.toString();
        }
        catch (Exception ex)
        {
            throw new Exception(ex.getMessage());
        }
    }

    private String Put(ApiRequest apiRequest, String urlService) throws Exception
    {
        return null;
    }

    private String Delete(ApiRequest apiRequest, String urlService) throws Exception
    {
        return null;
    }
}
