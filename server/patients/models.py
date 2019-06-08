from django.db import models
from django_extensions.db.models import TimeStampedModel

from skills.models import Skill
from users.models import User


class Patient(TimeStampedModel):
    user = models.OneToOneField(User, on_delete=models.CASCADE)
    requirements = models.ManyToManyField(Skill, blank=True)
    invalid_group = models.IntegerField(default=0)
    diagnosis = models.TextField(blank=True)
    address = models.CharField(max_length=250, blank=True)

    def __str__(self):
        return f'Patient {self.id}: {self.user}'
