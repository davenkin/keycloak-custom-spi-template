package davenkin.keycloak;


import org.jboss.logging.Logger;
import org.keycloak.Config.Scope;
import org.keycloak.authentication.Authenticator;
import org.keycloak.authentication.AuthenticatorFactory;
import org.keycloak.models.AuthenticationExecutionModel;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.KeycloakSessionFactory;
import org.keycloak.provider.ProviderConfigProperty;

import java.util.List;

public class MyCustomAuthenticatorFactory implements AuthenticatorFactory {
    private static final Logger logger = Logger.getLogger(MyCustomAuthenticator.class);

    @Override
    public String getId() {
        return "my-custom-authenticator";
    }

    @Override
    public String getDisplayType() {
        return "My Custom Authenticator";
    }

    @Override
    public String getReferenceCategory() {
        return null;
    }

    @Override
    public boolean isConfigurable() {
        return true;
    }

    @Override
    public AuthenticationExecutionModel.Requirement[] getRequirementChoices() {
        return new AuthenticationExecutionModel.Requirement[]{
                AuthenticationExecutionModel.Requirement.REQUIRED,
                AuthenticationExecutionModel.Requirement.DISABLED,
                AuthenticationExecutionModel.Requirement.ALTERNATIVE
        };
    }

    @Override
    public boolean isUserSetupAllowed() {
        return true;
    }

    @Override
    public String getHelpText() {
        return "My Custom Authenticator Help Text";
    }

    @Override
    public List<ProviderConfigProperty> getConfigProperties() {
        return List.of();
    }

    @Override
    public Authenticator create(KeycloakSession keycloakSession) {
        logger.info("Creating My Custom Authenticator");
        logger.info(keycloakSession.getContext().getHttpRequest().getUri().getAbsolutePath().toString());
        return new MyCustomAuthenticator();
    }

    @Override
    public void init(Scope scope) {
        logger.info("My Custom Authenticator init()");
    }

    @Override
    public void postInit(KeycloakSessionFactory keycloakSessionFactory) {

    }

    @Override
    public void close() {

    }

}