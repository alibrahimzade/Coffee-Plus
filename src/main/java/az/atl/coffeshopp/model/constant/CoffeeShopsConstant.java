package az.atl.coffeshopp.model.constant;

public enum CoffeeShopsConstant {
    FEATURE_ALREADY_EXIST("Feature already exist"),
    NO_SUCH_FEATURE("Feature does not exist"),
    PARTNER_ALREADY_EXIST("Partner already exist"),
    NO_SUCH_PARTNER("Partner does not exist"),
    USER_ALREADY_EXIST("User already exist"),
    NO_SUCH_USER("User does not exist");


    String value;

    CoffeeShopsConstant(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }
}
