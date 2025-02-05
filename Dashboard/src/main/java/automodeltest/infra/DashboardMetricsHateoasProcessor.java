package automodeltest.infra;

import automodeltest.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class DashboardMetricsHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<DashboardMetrics>> {

    @Override
    public EntityModel<DashboardMetrics> process(
        EntityModel<DashboardMetrics> model
    ) {
        return model;
    }
}
