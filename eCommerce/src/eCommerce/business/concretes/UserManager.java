package eCommerce.business.concretes;

import eCommerce.business.abstracts.UserService;
import eCommerce.core.abstracts.InputVerificationService;
import eCommerce.core.abstracts.ValidatorService;
import eCommerce.dataAccess.abstracts.UserDaoService;
import eCommerce.entities.concretes.User;

public class UserManager implements UserService {

    InputVerificationService memberInformationValidation;
    UserDaoService userDaoService;
    ValidatorService validatorService;

    public UserManager(InputVerificationService memberInformationValidation,
                       UserDaoService userDaoService, ValidatorService validatorService) {
        this.memberInformationValidation = memberInformationValidation;
        this.userDaoService = userDaoService;
        this.validatorService = validatorService;

    }


    @Override
    public void register(User user) {
        if (!memberInformationValidation.isValid(user)) {
            System.out.println("Kullan�c� bilgileri yanl�� girilmi�tir.");
            System.out.println("L�tfen ald���n�z uyar�y�a g�re bilgilerinizi g�ncelleyiniz.");
        } else if (!userDaoService.emailCheck(user)) {
            System.out.println("Bu e-mail adresi kullanlmaktad�r: " + user.geteMail() + "\n" + "L�tfen ba�ka bir e-mail adresi giriniz.");

        } else {
            userDaoService.add(user);
            validatorService.sendVarificationMail();
        }
    }

    @Override
    public void login(String email, String password) {
        if (userDaoService.loginByCheck(email, password)) {
            System.out.println("Kullan�c� giri�i ba�ar�l�. Ho�geldiniz...");
        } else {
            System.out.println("Kullan�c� ad� veya �ifre hatal� l�tfen tekrar deneyiniz");
        }
    }
}