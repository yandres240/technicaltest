package com.appgate.technicaltest.services.Models;

import java.util.ArrayList;

public class ApiRequest {

    public ApiRequest(Api api, com.appgate.technicaltest.services.Models.TypeRequest typeRequest, String objectData, String endPoint, ArrayList<ParameterHeader> pathParameters, ArrayList<ParameterHeader> queryParameters) {
        Api = api;
        TypeRequest = typeRequest;
        ObjectData = objectData;
        EndPoint = endPoint;
        PathParameters = pathParameters;
        QueryParameters = queryParameters;
    }

    private TypeRequest TypeRequest;
    private String ObjectData;
    private String EndPoint;
    private ArrayList<ParameterHeader> PathParameters;
    private ArrayList<ParameterHeader> QueryParameters;
    private Api Api;

    public Api getApi() {
        return Api;
    }

    public void setApi(Api api) {
        Api = api;
    }

    public com.appgate.technicaltest.services.Models.TypeRequest getTypeRequest() {
        return TypeRequest;
    }

    public void setTypeRequest(com.appgate.technicaltest.services.Models.TypeRequest typeRequest) {
        TypeRequest = typeRequest;
    }

    public String getObjectData() {
        return ObjectData;
    }

    public void setObjectData(String objectData) {
        ObjectData = objectData;
    }

    public String getEndPoint() {
        return EndPoint;
    }

    public void setEndPoint(String endPoint) {
        EndPoint = endPoint;
    }

    public ArrayList<ParameterHeader> getPathParameters() {
        return PathParameters;
    }

    public void setPathParameters(ArrayList<ParameterHeader> pathParameters) {
        PathParameters = pathParameters;
    }

    public ArrayList<ParameterHeader> getQueryParameters() {
        return QueryParameters;
    }

    public void setQueryParameters(ArrayList<ParameterHeader> queryParameters) {
        QueryParameters = queryParameters;
    }
}
