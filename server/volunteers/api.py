from rest_framework.viewsets import ModelViewSet

from users.permissions import HasUserOrReadOnly
from volunteers.models import Volunteer
from volunteers.serializers import VolunteerSerializer


class VolunteerViewSet(ModelViewSet):
    model = Volunteer
    serializer_class = VolunteerSerializer
    permission_classes = (HasUserOrReadOnly,)
    queryset = Volunteer.objects.all()
