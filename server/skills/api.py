from rest_framework.permissions import IsAuthenticated
from rest_framework.viewsets import ModelViewSet

from skills.models import Skill
from skills.serializers import SkillSerializer


class SkillViewSet(ModelViewSet):
    model = Skill
    serializer_class = SkillSerializer
    permission_classes = (IsAuthenticated,)
    queryset = Skill.objects.all()
