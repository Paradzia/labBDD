import cucumber.api.PendingException;
import cucumber.api.java.pl.Gdy;
import cucumber.api.java.pl.I;
import cucumber.api.java.pl.Wtedy;
import cucumber.api.java.pl.Zakładając;

public class ArrivalTimeSteps {

    @Zakładając("^chcę się dostać z (.*) do (.*)$")
    public void chcęSięDostaćZ_A_Do_B(String miasto1, String miasto2) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @I("^następny pociąg odjeżdża o (\\d+):(\\d+) na linii (.*)$")
    public void następnyPociągOdjeżdżaONaLiniiWestern(int hh, int mm, String linia) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Gdy("^zapytam o godzinę przyjazdu$") public void zapytamOGodzinęPrzyjazdu() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Wtedy("^powinienem uzyskać następujący szacowany czas przyjazdu: (\\d+):(\\d+)$")
    public void powinienemUzyskaćNastępującySzacowanyCzasPrzyjazdu(int hh, int mm) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
