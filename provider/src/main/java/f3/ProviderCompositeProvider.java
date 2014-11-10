package f3;

import javax.xml.namespace.QName;
import java.util.Collections;
import java.util.List;

import org.fabric3.api.annotation.model.Provides;
import org.fabric3.api.binding.zeromq.builder.ZeroMQBindingDefinitionBuilder;
import org.fabric3.api.binding.zeromq.model.ZeroMQBindingDefinition;
import org.fabric3.api.model.type.builder.ChannelDefinitionBuilder;
import org.fabric3.api.model.type.builder.CompositeBuilder;
import org.fabric3.api.model.type.component.ChannelDefinition;
import org.fabric3.api.model.type.component.Composite;

/**
 * Demonstrates the Fabric3 DSL for creating a composite.
 */
public class ProviderCompositeProvider {
    private static final String PROVIDER_CHANNEL_ADDRESS = "127.0.0.1:12001";
    private static final QName COMPOSITE = new QName("urn:fastquote.org", "ProviderComposite");

    @Provides
    public static Composite createComposite() {
        CompositeBuilder compositeBuilder = CompositeBuilder.newBuilder(COMPOSITE);
        compositeBuilder.channel(createProviderChannel());
        return compositeBuilder.deployable().build();
    }

    private static ChannelDefinition createProviderChannel() {
        ChannelDefinitionBuilder builder = ChannelDefinitionBuilder.newBuilder("ProviderChannel");
        List<String> addresses = Collections.singletonList(PROVIDER_CHANNEL_ADDRESS);
        ZeroMQBindingDefinition binding = ZeroMQBindingDefinitionBuilder.newBuilder().address(addresses).build();
        builder.binding(binding);
        return builder.build();
    }

}
