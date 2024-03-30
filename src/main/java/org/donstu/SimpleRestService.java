package org.donstu;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.HttpServer;
import org.donstu.domain.Show;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SimpleRestService {
    private static final int PORT = 8091;
    private static final int OK = 200;
    private static final int NOT_ALLOWED = 405;
    private static final int NOT_FOUND = 404;

    private static List<Show> shows = new ArrayList<>();

    static {
        shows.add(new Show("Two people","Two people in the elevator, not counting tequila", new Date(), 130, "First"));
        shows.add(new Show("Crazy Day","Crazy Day, or the Marriage of Figaro", new Date(), 145, "Second"));
        shows.add(new Show("DON","Quiet Don", new Date(), 180, "Second"));
        shows.add(new Show("Wonder","It's a Wonderful Life", new Date(), 210, "First"));
    }

    public static void main(String[] args) {
        try {
            HttpServer httpServer = HttpServer.create(new InetSocketAddress(PORT), 0);
            /// ----------------------------------------------------------
            httpServer.createContext("/show/list", httpExchange -> {
                if ("GET".equals(httpExchange.getRequestMethod())) {
                    httpExchange.getResponseHeaders().set("Content-Type", "application/json");
                    httpExchange.sendResponseHeaders(OK, 0);
                    ObjectMapper mapper = new ObjectMapper();
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    mapper.writeValue(baos, shows);
                    byte[] body = baos.toByteArray();
                    OutputStream os = httpExchange.getResponseBody();
                    os.write(body);
                    os.close();
                } else {
                    httpExchange.sendResponseHeaders(NOT_ALLOWED, -1);
                }
            });

            httpServer.createContext("/show/title", httpExchange -> {
                if ("GET".equals(httpExchange.getRequestMethod())) {
                    String[] requestParts = httpExchange.getRequestURI().getPath().split("/");
                    if (requestParts.length == 4) {
                        String showTitle = requestParts[3];
                        Show foundShow = null;
                        for (Show show : shows) {
                            if (show.getTitle().equalsIgnoreCase(showTitle)) {
                                foundShow = show;
                                break;
                            }
                        }
                        if (foundShow != null) {
                            httpExchange.getResponseHeaders().set("Content-Type", "application/json");
                            httpExchange.sendResponseHeaders(OK, 0);
                            ObjectMapper mapper = new ObjectMapper();
                            ByteArrayOutputStream baos = new ByteArrayOutputStream();
                            mapper.writeValue(baos, foundShow);
                            byte[] body = baos.toByteArray();
                            OutputStream os = httpExchange.getResponseBody();
                            os.write(body);
                            os.close();
                        } else {
                            httpExchange.getResponseHeaders().set("Content-Type", "application/json");
                            httpExchange.sendResponseHeaders(OK, 0);
                            OutputStream os = httpExchange.getResponseBody();
                            os.write("{}".getBytes());
                            os.close();
                        }
                    } else {
                        httpExchange.sendResponseHeaders(NOT_FOUND, -1);
                    }
                } else {
                    httpExchange.sendResponseHeaders(NOT_ALLOWED, -1);
                }
            });


            httpServer.createContext("/show/id", httpExchange -> {
                if ("GET".equals(httpExchange.getRequestMethod())) {
                    String[] requestParts = httpExchange.getRequestURI().getPath().split("/");
                    if (requestParts.length == 4) {
                        String showId = requestParts[3];
                        Show foundShow = null;
                        for (Show show : shows) {
                            if (show.getIdent().equalsIgnoreCase(showId)) {
                                foundShow = show;
                                break;
                            }
                        }
                        if (foundShow != null) {
                            httpExchange.getResponseHeaders().set("Content-Type", "application/json");
                            httpExchange.sendResponseHeaders(OK, 0);
                            ObjectMapper mapper = new ObjectMapper();
                            ByteArrayOutputStream baos = new ByteArrayOutputStream();
                            mapper.writeValue(baos, foundShow);
                            byte[] body = baos.toByteArray();
                            OutputStream os = httpExchange.getResponseBody();
                            os.write(body);
                            os.close();
                        } else {
                            httpExchange.getResponseHeaders().set("Content-Type", "application/json");
                            httpExchange.sendResponseHeaders(OK, 0);
                            OutputStream os = httpExchange.getResponseBody();
                            os.write("{}".getBytes());
                            os.close();
                        }
                    } else {
                        httpExchange.sendResponseHeaders(NOT_FOUND, -1);
                    }
                } else {
                    httpExchange.sendResponseHeaders(NOT_ALLOWED, -1);
                }
            });



            httpServer.setExecutor(null);
            httpServer.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
