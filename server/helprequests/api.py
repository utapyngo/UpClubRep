from rest_framework.viewsets import ModelViewSet

from helprequests.models import HelpRequest
from helprequests.permissions import OwnRequestOrReadOnly
from helprequests.serializers import HelpRequestSerializer


class HelpRequestViewSet(ModelViewSet):
    serializer_class = HelpRequestSerializer
    permission_classes = (OwnRequestOrReadOnly,)
    queryset = HelpRequest.objects.all()
    filterset_fields = ('patient', 'title', 'text', 'skill')
    search_fields = ('patient__address', 'title', 'text', 'skill__name')
