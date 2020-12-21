package TestProject.cucumberTests.dataTableConfig;

import TestProject.cucumberTests.models.User;
import cucumber.api.TypeRegistry;
import cucumber.api.TypeRegistryConfigurer;
import io.cucumber.datatable.DataTableType;
import io.cucumber.datatable.TableEntryTransformer;

import java.util.Locale;

public class DataTableConfigurer implements TypeRegistryConfigurer {

    @Override
    public Locale locale() {
        return Locale.ENGLISH;
    }

    @Override
    public void configureTypeRegistry(TypeRegistry registry) {
        registry.defineDataTableType(new DataTableType(User.class, (TableEntryTransformer<User>) entry -> new User(entry.get("username"), entry.get("password"))));
    }
}
