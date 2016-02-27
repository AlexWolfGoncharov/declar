package com.github.alexwolfgoncharov.declar.controllers.web;

import com.github.alexwolfgoncharov.declar.Response.ODeclar;
import com.github.alexwolfgoncharov.declar.Response.ResponseList;
import com.github.alexwolfgoncharov.declar.util.PostUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Created by alexwolf on 01.02.16.
 */

@Controller
public class MainController {


    private static final Logger log = Logger.getLogger(MainController.class
            .getName());


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String start(Model model) {

        return "redirect:/declar";
    }




    @RequestMapping(value = "/declar")
    public String getAll(Map<String, Object> map,
                         HttpServletRequest requestBody){


        PostUtil postUtil = new PostUtil();
        ResponseList resultSaldo = null, resultCredo = null;
        String SID = "";
        String INN = "";
        DateFormat formatToXML = new SimpleDateFormat("yyyyMMdd");
        DateFormat formatFromForm = new SimpleDateFormat("dd.MM.yyyy");
        Date start = new Date();
        Date end = new Date();

        Map<String, String[]> parametrs =  requestBody.getParameterMap();
       if (parametrs.containsKey("SID")) {
           SID = parametrs.get("SID")[0];
           map.put("SID", SID);


           if (parametrs.containsKey("INN")) {


               INN = parametrs.get("INN")[0];
               map.put("INN", INN);

               if (parametrs.containsKey("start")) {

                   Date starT = new Date();
                   try {
                       starT = formatFromForm.parse(parametrs.get("start")[0]);
                   } catch (ParseException e) {
                       log.warning(e.getMessage());
                   }


//            starT.setDate(-1);
                   start = new Date(starT.getTime());
                   map.put("start", formatFromForm.format(start));

                   Date enD = new Date(end.getTime() + (1000 * 60 * 60 * 24));


                   if (parametrs.containsKey("end")) {


                       try {

                           enD = formatFromForm.parse(parametrs.get("end")[0]);



                       } catch (ParseException e) {
                           log.warning(e.getMessage());
                       }


                   }

                   end = new Date(enD.getTime());
                   map.put("end", formatFromForm.format(end));

               }


           }

       }




        String SaldoDec = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\t<doc>\t <r t='SaldoDeclar' sid='" + SID + "'><i INN='"+ INN +"' /><i DATEFROM='"
                + formatToXML.format(start) + "' /><i DATETO='" + formatToXML.format(end) + "' /></r></doc>";


        String CredoDec = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\t<doc>\t<r t='CredDeclar' sid='" + SID + "'><i INN='"+ INN +"' /><i DATEFROM='"
                + formatToXML.format(start) + "' /><i DATETO='" + formatToXML.format(end) + "' /></r></doc>";


        String answerSaldo = "";

        String answerCredo = "";


        if (!SID.equals("") && !INN.equals("")) {

            try {
                answerSaldo = postUtil.sendPost(SaldoDec);

                answerCredo = postUtil.sendPost(CredoDec);


                JAXBContext context =
                        JAXBContext.newInstance(ResponseList.class);

                //демаршалинг
                Unmarshaller umarshaller =
                        context.createUnmarshaller();
                StringReader xml = new StringReader(answerSaldo);

                resultSaldo = (ResponseList) umarshaller.unmarshal(xml);


                xml = new StringReader(answerCredo);

                resultCredo = (ResponseList) umarshaller.unmarshal(xml);


            } catch (Exception e) {
                e.printStackTrace();
            }


            if (resultSaldo != null) {
                List<ODeclar> saldoODeclarList = resultSaldo.getR().getoDeclars();

                List<ODeclar> newSaldoODeclarList = new LinkedList<>();

                if (saldoODeclarList != null) {

                    for (ODeclar declar : saldoODeclarList) {

                        if (declar.getNALOG() != null && declar.getVOEN_SBOR() == null) {
                            double nalog = Double.parseDouble(declar.getNALOG());
                            double nalogEq = Double.parseDouble(declar.getNALOG_EQ());

                            double voenSbor = (nalog * 0.015) / 0.215;
                            double voenSborEq = (nalogEq * 0.015) / 0.215;

                            nalog = nalog - voenSbor;
                            nalogEq = nalogEq - voenSborEq;


                            declar.setNALOG(String.valueOf(nalog));
                            declar.setNALOG_EQ(String.valueOf(nalogEq));
                            declar.setVOEN_SBOR(String.valueOf(voenSbor));
                            declar.setVOEN_SBOR_EQ(String.valueOf(voenSborEq));


                        }

                        newSaldoODeclarList.add(declar);
                    }

                    map.put("SaldoODeclarList", newSaldoODeclarList);
                }
            }


            if (resultCredo != null) {

                List<ODeclar> credoDeclarList = resultCredo.getR().getoDeclars();
                map.put("credoDeclarList", credoDeclarList);

            }

        }

        return "declar";
    }







}
