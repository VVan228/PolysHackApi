package hack.polyus.goldenrush.services;

import hack.polyus.goldenrush.models.schedule.Schedule;
import hack.polyus.goldenrush.models.transport.Request;
import hack.polyus.goldenrush.models.transport.Transport;

import java.util.List;

public interface ScheduleGenerator {
    Schedule generate(List<Transport> transportList, List<Request> requests);
}
