package TestProject.cucumberTests.steps.dataTableConfig;

import TestProject.cucumberTests.models.Product;
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
        registry.defineDataTableType(
                new DataTableType(
                        User.class,                                                                                     // type
                        (TableEntryTransformer<User>) entry -> new User(entry.get("username"), entry.get("password"))   // transformer
                )
        );
        registry.defineDataTableType(
                new DataTableType(
                        Product.class,
                        (TableEntryTransformer<Product>) entry -> new Product(entry.get("name"), entry.get("currentPrice"),
                                entry.get("oldPrice"),entry.get("discount"))
                )
        );
    }
}
