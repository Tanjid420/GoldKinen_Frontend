// import React from 'react';
import useFetchData from '../hooks/useFetchData';
import PostCard from '../components/PostCard';
import Loader from '../components/Loader';

const Timeline = () => {
  const { data, loading, error } = useFetchData();

  if (loading) return <Loader />;
  if (error) return <p>Error loading data: {error.message}</p>;

  const { posts, users, comments } = data;

  const getUserById = (id) => users.find(user => user.id === id);
  const getCommentsByPostId = (postId) => comments.filter(comment => comment.postId === postId);

  return (
    <div className="container mx-auto p-6">
      {posts.sort((a, b) => b.id - a.id).map(post => (
        <PostCard key={post.id} post={post} user={getUserById(post.userId)} comments={getCommentsByPostId(post.id)} />
      ))}
    </div>
  );
};

export default Timeline;
