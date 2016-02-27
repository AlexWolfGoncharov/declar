import com.github.alexwolfgoncharov.declar.Response.ODeclar;
import com.github.alexwolfgoncharov.declar.Response.ResponseList;

import javax.net.ssl.HttpsURLConnection;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.URL;

/**
 * Created by alexwolf on 26.02.16.
 */
public class TestMarshaller {


    public static void main (String ... agrs){

        ResponseList resultSaldo = null;

        String xmlOut = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\t<doc>\t    <r >\t        <O  CURR=\"USD\" OSTATOK=\"5861.43\" OSTATOK_EQ=\"140678.22\" REF=\"5523245100014453\" TYPE=\"MC WORLD ELITE ЧИП+ПИН\"/>\t        <O  CLIENT_MONEY=\"16891.29\" CLIENT_MONEY_EQ=\"419268.04\" CURR=\"EUR\" REF=\"26201708266960\" TYPE=\"Счет/карта\"/>\t        <O  CURR=\"RUR\" OSTATOK=\"0.25\" OSTATOK_EQ=\"0.08\" REF=\"26209603384648\" TYPE=\"Счет/карта\"/>\t        <O  CURR=\"EUR\" OSTATOK=\"129.73\" OSTATOK_EQ=\"3401.92\" REF=\"5218572211515932\" TYPE=\"MASTERCARD PLATINUM CHIP+PAYPASS BEZ PIN\"/>\t        <O  CURR=\"UAH\" OSTATOK=\"117905.50\" OSTATOK_EQ=\"117905.50\" REF=\"4176490038000280\" TYPE=\"VISA INFINITE\"/>\t        <O  CLIENT_MONEY=\"962.96\" CLIENT_MONEY_EQ=\"17277.42\" CURR=\"EUR\" NACH_PROC=\"44.44\" NACH_PROC_EQ=\"1111.54\" NALOG=\"9.55\" NALOG_EQ=\"235.46\" OSTATOK=\"997.54\" OSTATOK_EQ=\"26158.62\" REF=\"26201604842176\" TYPE=\"Счет/карта\" ZACH_PROC=\"34.58\" ZACH_PROC_EQ=\"870.33\"/>\t        <O  CURR=\"USD\" OSTATOK=\"2529.06\" OSTATOK_EQ=\"60699.12\" REF=\"26359600028506\" TYPE=\"ДЕПОЗИТ\"/>\t        <O  CLIENT_MONEY=\"804.72\" CLIENT_MONEY_EQ=\"17704.58\" CURR=\"USD\" OSTATOK=\"185.58\" OSTATOK_EQ=\"4454.04\" REF=\"4149605710002353\" TYPE=\"INTERNET CARD VIP\"/>\t        <O  CLIENT_MONEY=\"1000.00\" CLIENT_MONEY_EQ=\"1000.00\" CURR=\"UAH\" REF=\"26208701951673\" TYPE=\"Счет/карта\"/>\t        <O  CLIENT_MONEY=\"1080.00\" CLIENT_MONEY_EQ=\"25779.69\" CURR=\"GBP\" REF=\"26204602381625\" TYPE=\"Счет/карта\"/>\t    </r>\t</doc>\n";

        String xmlIn  = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><doc><r t='SaldoDeclar' sid='160226csd1xmxlkixhaq'><i INN='2622809479' /><i DATEFROM='20150101' /><i DATETO='20151231' /></r></doc>";




        JAXBContext context =
                null;
        try {
            String test = sendPost(xmlIn);
            context = JAXBContext.newInstance(ResponseList.class);


        //демаршалинг
        Unmarshaller umarshaller =
                context.createUnmarshaller();
        StringReader xml = new StringReader(test);

         resultSaldo = (ResponseList) umarshaller.unmarshal(xml);

        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if(resultSaldo != null){

            System.out.println(resultSaldo.toString());
        }

        ODeclar declar = resultSaldo.getR().getoDeclars().get(0);
       if( declar.getNALOG() != null && declar.getVOEN_SBOR() == null){
           System.out.printf("UUU");
       }

    }



    private static String sendPost(String send) throws Exception {

        String USER_AGENT = "Mozilla/5.0";

        String url = "https://iq.privatbank.ua/488";
        URL obj = new URL(url);
        HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

        //add reuqest header
        con.setRequestMethod("POST");
        con.setRequestProperty("User-Agent", USER_AGENT);
//        con.setRequestProperty("Content-Type:", "text/xml");
        con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");



        // Send post request
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(send);
        wr.flush();
        wr.close();

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'POST' request to URL : " + url);
        System.out.println("Post parameters : " + send);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();


       String  answer = response.toString();
        //print result
        System.out.println(response.toString());
        return  answer;

    }

}
