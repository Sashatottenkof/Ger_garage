package finalproject.Ger_garage.Service;


import finalproject.Ger_garage.Models.User;
import finalproject.Ger_garage.Models.VerificationToken;
import finalproject.Ger_garage.Repositories.VerificationTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Calendar;

@Service
public class VerificationTokenService {

    @Autowired
    private VerificationTokenRepository verificationTokenRepository;

    public VerificationToken findByUser(User user) {
        return verificationTokenRepository.findByUser(user);
    }

    public VerificationToken findByToken(String token) {
        return verificationTokenRepository.findByToken(token);
    }

    public void saveToken(User user, String token) {
        VerificationToken verificationToken = new VerificationToken(user, token);

        //set expiry date to 24 hours
        verificationToken.setExpiryDate(CalculateExpiryDate(24 * 60));

        verificationTokenRepository.save(verificationToken);
    }

    /**
     * Calculate expiry Date
     * we add 24 hours to a current date and time to get new timestamp
     * which we gonna compare to a new current date latter on
     * to make sure that token hasn't expired
     * @param expiryTimeInMinutes
     * @return
     */
    public Timestamp CalculateExpiryDate(int expiryTimeInMinutes) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MINUTE, expiryTimeInMinutes);
        return new Timestamp(cal.getTime().getTime());
    }

}
