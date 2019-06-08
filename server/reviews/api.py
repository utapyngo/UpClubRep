from rest_framework.viewsets import ModelViewSet

from reviews.models import Review
from reviews.permissions import FromUserOrReadOnly
from reviews.serializers import ReviewSerializer


class ReviewViewSet(ModelViewSet):
    model = Review
    serializer_class = ReviewSerializer
    permission_classes = (FromUserOrReadOnly,)
    queryset = Review.objects.all()
