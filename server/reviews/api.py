from rest_framework.viewsets import ModelViewSet

from reviews.models import Review
from reviews.serializers import ReviewSerializer
from users.permissions import HasUserOrReadOnly


class ReviewViewSet(ModelViewSet):
    model = Review
    serializer_class = ReviewSerializer
    permission_classes = (HasUserOrReadOnly,)
    queryset = Review.objects.all()
