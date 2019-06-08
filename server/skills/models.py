from django.db import models
from django_extensions.db.models import TimeStampedModel


class Skill(TimeStampedModel):
    name = models.CharField(max_length=40)

    def __str__(self):
        return self.name
