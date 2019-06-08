from rest_framework.viewsets import ModelViewSet

from patients.models import Patient
from patients.serializers import PatientSerializer
from users.permissions import HasUserOrReadOnly


class PatientViewSet(ModelViewSet):
    model = Patient
    serializer_class = PatientSerializer
    permission_classes = (HasUserOrReadOnly,)
    queryset = Patient.objects.all()
