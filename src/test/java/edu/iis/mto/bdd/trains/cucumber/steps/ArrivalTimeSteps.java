package edu.iis.mto.bdd.trains.cucumber.steps;

import cucumber.api.PendingException;
import cucumber.api.Transform;
import cucumber.api.java.pl.Gdy;
import cucumber.api.java.pl.I;
import cucumber.api.java.pl.Wtedy;
import cucumber.api.java.pl.Zakładając;
import org.joda.time.LocalTime;

public class ArrivalTimeSteps {

    @Zakładając("^chcę się dostać z (.*) do (.*)$")
    public void chcęSięDostaćZ_A_Do_B(String miasto1, String miasto2) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @I("^następny pociąg odjeżdża o (.*) na linii (.*)$")
    public void następnyPociągOdjeżdżaONaLiniiWestern(@Transform(JodaLocalTimeConverter.class) LocalTime departTime, String linia) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Gdy("^zapytam o godzinę przyjazdu$") public void zapytamOGodzinęPrzyjazdu() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Wtedy("^powinienem uzyskać następujący szacowany czas przyjazdu: (.*)$")
    public void powinienemUzyskaćNastępującySzacowanyCzasPrzyjazdu(@Transform(JodaLocalTimeConverter.class) LocalTime departTime) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
