package f3;

import javax.xml.namespace.QName;
import java.util.Collections;
import java.util.List;

import org.fabric3.api.annotation.model.Provides;
import org.fabric3.api.binding.zeromq.builder.ZeroMQBindingBuilder;
import org.fabric3.api.binding.zeromq.model.ZeroMQBinding;
import org.fabric3.api.model.type.builder.ChannelBuilder;
import org.fabric3.api.model.type.builder.CompositeBuilder;
import org.fabric3.api.model.type.component.Channel;
import org.fabric3.api.model.type.component.Composite;

/**
 * Demonstrates the Fabric3 DSL for creating a composite.
 */
public class AggregationCompositeProvider {
    private static final String PROVIDER_CHANNEL_ADDRESS = "127.0.0.1:12001";
    private static final String REPLICATION_CHANNEL_ADDRESS = "127.0.0.1:13001";
    private static final QName COMPOSITE = new QName("urn:fastquote.org", "AggregationComposite");

    @Provides
    public static Composite createComposite() {
        CompositeBuilder compositeBuilder = CompositeBuilder.newBuilder(COMPOSITE);
        compositeBuilder.channel(createProviderChannel());
        compositeBuilder.channel(createReplicationChannel());
        return compositeBuilder.deployable().build();
    }

    private static Channel createProviderChannel() {
        ChannelBuilder builder = ChannelBuilder.newBuilder("ProviderChannel");
        List<String> addresses = Collections.singletonList(PROVIDER_CHANNEL_ADDRESS);
        ZeroMQBinding binding = ZeroMQBindingBuilder.newBuilder().address(addresses).build();
        builder.binding(binding);
        return builder.build();
    }

    private static Channel createReplicationChannel() {
        ChannelBuilder builder = ChannelBuilder.newBuilder("ReplicationChannel");
        List<String> addresses = Collections.singletonList(REPLICATION_CHANNEL_ADDRESS);
        ZeroMQBinding binding = ZeroMQBindingBuilder.newBuilder().address(addresses).build();
        builder.binding(binding);
        return builder.build();
    }

}
