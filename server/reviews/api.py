from rest_framework.viewsets import ModelViewSet

from reviews.models import Review
from reviews.permissions import FromUserOrReadOnly
from reviews.serializers import ReviewSerializer


class ReviewViewSet(ModelViewSet):
    model = Review
    serializer_class = ReviewSerializer
    permission_classes = (FromUserOrReadOnly,)
    queryset = Review.objects.all()
    filterset_fields = ('text', 'rating', 'from_member', 'to_member',)
    search_fields = ('text', 'rating', 'from_member__user__email', 'to_member__user__email',)
