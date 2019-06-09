from rest_framework.viewsets import ModelViewSet

from patients.models import Patient
from patients.serializers import PatientSerializer
from users.permissions import HasUserOrReadOnly


class PatientViewSet(ModelViewSet):
    model = Patient
    serializer_class = PatientSerializer
    permission_classes = (HasUserOrReadOnly,)
    queryset = Patient.objects.all()
    filterset_fields = ('address', 'requirements', 'user', 'diagnosis', 'invalid_group')
    search_fields = (
        'address', 'requirements__name', 'diagnosis',
        'user__first_name', 'user__middle_name', 'user__last_name', 'user__email',
    )
