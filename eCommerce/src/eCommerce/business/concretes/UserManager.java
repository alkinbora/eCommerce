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
            System.out.println("Kullanýcý bilgileri yanlýþ girilmiþtir.");
            System.out.println("Lütfen aldýðýnýz uyarýyýa göre bilgilerinizi güncelleyiniz.");
        } else if (!userDaoService.emailCheck(user)) {
            System.out.println("Bu e-mail adresi kullanlmaktadýr: " + user.geteMail() + "\n" + "Lütfen baþka bir e-mail adresi giriniz.");

        } else {
            userDaoService.add(user);
            validatorService.sendVarificationMail();
        }
    }

    @Override
    public void login(String email, String password) {
        if (userDaoService.loginByCheck(email, password)) {
            System.out.println("Kullanýcý giriþi baþarýlý. Hoþgeldiniz...");
        } else {
            System.out.println("Kullanýcý adý veya þifre hatalý lütfen tekrar deneyiniz");
        }
    }
}