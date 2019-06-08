from rest_framework.permissions import AllowAny
from rest_framework.viewsets import ModelViewSet

from users.models import User
from users.permissions import IsUserOrReadOnly
from .serializers import UserSerializer


class UserViewSet(ModelViewSet):
    model = User
    serializer_class = UserSerializer
    permission_classes = (IsUserOrReadOnly,)
    queryset = User.objects.all()

    def create(self, request, *args, **kwargs):
        self.permission_classes = (AllowAny,)
        return super().create(request, *args, **kwargs)
