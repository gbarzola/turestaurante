package com.sourcey.turestaurante.Api;

/**
 * Created by Usuario on 7/04/2018.
 */

public class ApiUser {

    private static final String ROOT_URL = "http://192.168.1.101/apiRestaurante/v1/Api.php?apicall=";

    public static final String URL_CREATE_USER = ROOT_URL + "createuser";
    public static final String URL_READ_USER = ROOT_URL + "getuser";
    public static final String URL_UPDATE_USER = ROOT_URL + "updateuser";
    public static final String URL_DELETE_USER = ROOT_URL + "deleteuser&id=";

    public static final String URL_LOGIN = "http://192.168.1.107:8081/apiRestaurante/v1/login.php";
}
