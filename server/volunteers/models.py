from django.contrib.auth.models import AbstractBaseUser
from django.contrib.auth.models import PermissionsMixin
from django.db import models
from django_extensions.db.models import TimeStampedModel

from skills.models import Skill
from users.models import User


class Volunteer(TimeStampedModel):
    user = models.OneToOneField(User, on_delete=models.CASCADE)
    rating = models.IntegerField(default=0)

    def __str__(self):
        return f'Volunteer {self.id}: {self.user} ({self.rating})'


class VolunteerSkill(TimeStampedModel):
    volunteer = models.ForeignKey(Volunteer, models.CASCADE)
    skill = models.ForeignKey(Skill, models.CASCADE)
    approved = models.DateTimeField(null=True, blank=True)
