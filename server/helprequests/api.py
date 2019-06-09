from rest_framework.permissions import AllowAny
from rest_framework.viewsets import ModelViewSet

from helprequests.models import HelpRequest
from helprequests.serializers import HelpRequestSerializer


class HelpRequestViewSet(ModelViewSet):
    serializer_class = HelpRequestSerializer
    permission_classes = (AllowAny,)
    queryset = HelpRequest.objects.all()
