package f3;

import javax.xml.namespace.QName;

import org.fabric3.api.annotation.model.Provides;
import org.fabric3.api.model.type.builder.CompositeBuilder;
import org.fabric3.api.model.type.builder.RingBufferChannelBuilder;
import org.fabric3.api.model.type.component.Channel;
import org.fabric3.api.model.type.component.Composite;

/**
 * Demonstrates the Fabric3 DSL for creating a composite.
 */
public class PublicationCompositeProvider {
    private static final QName COMPOSITE = new QName("urn:fastquote.org", "PublicationComposite");

    @Provides
    public static Composite createComposite() {
        // Creates a channel using the disruptor.
        Channel channel = RingBufferChannelBuilder.newBuilder("VenueChannel").build();
        return CompositeBuilder.newBuilder(COMPOSITE).channel(channel).deployable().build();
    }
}
