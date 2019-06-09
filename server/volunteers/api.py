from rest_framework.viewsets import ModelViewSet

from users.permissions import HasUserOrReadOnly
from volunteers.models import Volunteer
from volunteers.serializers import VolunteerSerializer


class VolunteerViewSet(ModelViewSet):
    model = Volunteer
    serializer_class = VolunteerSerializer
    permission_classes = (HasUserOrReadOnly,)
    queryset = Volunteer.objects.all()
    filterset_fields = ('skills', 'user', 'rating')
    search_fields = (
        'skills__name', 'rating',
        'user__first_name', 'user__middle_name', 'user__last_name', 'user__email',
    )
